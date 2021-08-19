package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TwitterDesign {
	
	class Pair{
		int timestamp;
		int tweetId;
		public Pair(int t , int tId)
		{
			timestamp = t;
			tweetId = tId;
		}
	}

	Map<Integer, List<Pair>> userTweetMap = new HashMap<>();
	Map<Integer, Set<Integer>> userfollowerMap = new HashMap<>();
	int timestamp = 0;
	/** Initialize your data structure here. */
    public TwitterDesign() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	List<Pair> tweetList = userTweetMap.get(userId);
        if(tweetList == null)
        {
        	tweetList = new ArrayList<>();
//        	userfollowerMap.put(userId, userId);
        	userTweetMap.put(userId, tweetList);
        	follow(userId, userId);
        }
        tweetList.add(new Pair(timestamp, tweetId));
        timestamp++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Queue<Pair> heap = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.timestamp - o2.timestamp;
			}
		});
        
        LinkedList<Integer> res = new LinkedList<>();
        if(!userfollowerMap.containsKey(userId)) return res;
        for(int followeeId : userfollowerMap.get(userId))
        {
        	if(userTweetMap.containsKey(followeeId))
        	{
	        	for(Pair tweet : userTweetMap.get(followeeId))
	        	{
	        		heap.offer(tweet);
	        		if(heap.size() > 10)
	        		{
	        			heap.poll();
	        		}
	        	}
        	}
        }
        
        while(!heap.isEmpty())
        {
        	res.addFirst(heap.poll().tweetId);
        }
        return res;
//        heap.stream().map(p -> p.tweetId).collect(Collectors.toList());
//    	return heap.stream().map(p -> p.tweetId).collect(Collectors.toList());
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	Set<Integer> followerList = userfollowerMap.get(followerId);
    	if(followerList == null)
    	{
    		followerList = new HashSet<>();
    		userfollowerMap.put(followerId, followerList);
    	}
    	followerList.add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	Set<Integer> followerList = userfollowerMap.get(followerId);
    	if(followerList != null)
    	{
    		followerList.remove(followeeId);
    	}
    }
    
    public static void main(String[] args) {
		TwitterDesign obj = new TwitterDesign();
		System.out.println(obj.getNewsFeed(1));
//		obj.postTweet(1, 5);
//		obj.follow(1, 2);
//		obj.postTweet(2, 6);
//		obj.postTweet(2, 7);
//		obj.postTweet(2, 8);
//		obj.postTweet(2, 9);
//		obj.postTweet(2, 10);
//		obj.postTweet(2, 11);
//		obj.postTweet(1, 12);
//		obj.postTweet(1, 13);
//		obj.postTweet(1, 14);
//		obj.postTweet(1, 15);
//		obj.postTweet(1, 16);
//
//
//		
//		System.out.println(obj.getNewsFeed(1));
//		obj.unfollow(1, 2);
//		
//		System.out.println(obj.getNewsFeed(1));

	}
}
