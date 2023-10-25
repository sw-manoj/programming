package org.example;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;

public class RateLimiter {


	public class RequestCounters {
		public NavigableMap<Long, Integer> counts;
		public int totalCounts;
		private final int requests;
		private final int windowTimeInSec;
		private final int bucketSize;
		private final Lock lock;

		public RequestCounters(int requests, int windowTimeInSec, int bucketSize) {
			this.counts = new TreeMap<>();
			this.totalCounts = 0;
			this.requests = requests;
			this.windowTimeInSec = windowTimeInSec;
			this.bucketSize = bucketSize;
			this.lock = new ReentrantLock();
		}

		public long getBucket(long timestamp) {
			long factor = windowTimeInSec / bucketSize;
			return (timestamp / factor) * factor;
		}

		private long getOldestValidBucket(long currentTimestamp) {
			return getBucket(currentTimestamp - windowTimeInSec);
		}

		public void evictOlderBuckets(long currentTimestamp) {
			long oldestValidBucket = getOldestValidBucket(currentTimestamp);

			// Since we are using a TreeMap, we can get all keys less than oldestValidBucket and delete them
			NavigableMap<Long, Integer> oldBuckets = counts.headMap(oldestValidBucket, false);
			System.out.println("oldestValidBucket  : " + oldestValidBucket + " === values == " + oldBuckets.size());

			for (Integer value : oldBuckets.values()) {
				totalCounts -= value;
			}
			oldBuckets.clear();
		}
	}




	public ConcurrentHashMap<String, RequestCounters> rateLimiterMap;
	private Lock globalLock;

	public RateLimiter() {
		this.rateLimiterMap = new ConcurrentHashMap<>();
		this.globalLock = new ReentrantLock();
	}


	public void addUser(String userId, int requests, int windowTimeInSec) {
		// Use compute to atomically compute each value
		rateLimiterMap.compute(userId, (key, existingValue) -> {
			if (existingValue != null) {
				throw new RuntimeException("User already present");
			}
			return new RequestCounters(requests, windowTimeInSec, 10);
		});
	}

	public void removeUser(String userId) {
		rateLimiterMap.remove(userId);
	}

	public static long getCurrentTimestampInSec() {
		return System.currentTimeMillis() / 1000;
	}
	public boolean shouldAllowServiceCall(String userId) throws Exception {
		// Fetch the RequestCounters object for the user
		RequestCounters userTimestamps = rateLimiterMap.get(userId);

		if (userTimestamps == null) {
			throw new Exception("User is not present");
		}

		// Lock on user-specific data
		userTimestamps.lock.lock();
		try {
			long currentTimestamp = getCurrentTimestampInSec();
			System.out.println("buket count before : " + userTimestamps.counts.size());
			// Evict older buckets
			userTimestamps.evictOlderBuckets(currentTimestamp);
			System.out.println("buket count after : " + userTimestamps.counts.size());

			// Update the current bucket count
			long currentBucket = userTimestamps.getBucket(currentTimestamp);
			userTimestamps.counts.put(currentBucket, userTimestamps.counts.getOrDefault(currentBucket, 0) + 1);

			// Update the total count
			userTimestamps.totalCounts++;

			// Check if the request exceeds the limit
			if (userTimestamps.totalCounts > userTimestamps.requests) {
				return false;
			}
			return true;
		} finally {
			userTimestamps.lock.unlock();
		}
	}


	public static void main(String[] args) {
		RateLimiter limiter = new RateLimiter();
		limiter.addUser("user1", 100, 60);

		// Test the rate limiter
		for (int i = 0; i < 110; i++) {
			try {
				System.out.println(limiter.shouldAllowServiceCall("user1"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
