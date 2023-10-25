import org.example.RateLimiter;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class SlidingWindowCounterRateLimiterTest {

	private RateLimiter rateLimiter;

	@Before
	public void setup() {
		rateLimiter = new RateLimiter();
	}

	@Test
	public void testBasicFunctionality() throws Exception {
		rateLimiter = new RateLimiter();

		rateLimiter.addUser("user1", 100, 60);
		for (int i = 0; i < 100; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user1"));
		}
		assertEquals(0, rateLimiter.rateLimiterMap.get("user1").totalCounts - 100);
	}

	@Test
	public void testExceedingLimit() throws Exception {
		rateLimiter.addUser("user2", 100, 60);
		for (int i = 0; i < 100; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user2"));
		}
		assertFalse(rateLimiter.shouldAllowServiceCall("user2"));
	}

	@Test
	public void testSlidingWindow() throws Exception {
		rateLimiter.addUser("user3", 100, 60);
		for (int i = 0; i < 50; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user3"));
		}

		// Simulate waiting for half of the window time (30 seconds in this case)
		Thread.sleep(30000);

		for (int i = 0; i < 50; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user3"));
		}
		assertFalse(rateLimiter.shouldAllowServiceCall("user3"));
	}

	@Test
	public void testUserManagement() throws Exception {
		rateLimiter.addUser("user4", 100, 60);
		assertTrue(rateLimiter.shouldAllowServiceCall("user4"));
		rateLimiter.removeUser("user4");
		assertThrows(Exception.class, () -> rateLimiter.shouldAllowServiceCall("user4"));
	}

	@Test
	public void testBucketEviction() throws Exception {
		rateLimiter.addUser("user3", 100, 60);
		for (int i = 0; i < 20; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user3"));
		}

		// Simulate waiting beyond the window time (a bit more than 60 seconds in this case)
		Thread.sleep(61000);

		for (int i = 0; i < 20; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user3"));
		}

		assertEquals(1, rateLimiter.rateLimiterMap.get("user3").counts.size());
	}

	@Test
	public void testBucketCount() throws Exception {
		rateLimiter.addUser("user2", 100, 60);
		for (int i = 0; i < 50; i++) {
			assertTrue(rateLimiter.shouldAllowServiceCall("user2"));
			Thread.sleep(1000);
		}

		long currentBucket = rateLimiter.rateLimiterMap.get("user2").getBucket(rateLimiter.getCurrentTimestampInSec());
		System.out.println("bucket :" + rateLimiter.rateLimiterMap.get("user2").counts.size());
		assertEquals(50, rateLimiter.rateLimiterMap.get("user2").counts.get(currentBucket).intValue());
	}
}
