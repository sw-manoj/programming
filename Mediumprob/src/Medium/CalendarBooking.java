package Medium;

import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

//https://leetcode.com/problems/my-calendar-i/
public class CalendarBooking {
	
	public static void main(String[] args) {
		CalendarBooking obj = new CalendarBooking();
		
		System.out.println(obj.book(10, 20));
		System.out.println(obj.book(15, 25));
//		System.out.println(obj.book(5, 10));
		System.out.println(obj.book(5, 11));
		System.out.println(obj.book(20, 25));




	}

	TreeMap<Integer, Integer> bookings = new TreeMap<>();
	public CalendarBooking() {
        
    }
    
    public boolean book(int start, int end) {
    	Map.Entry<Integer, Integer> beforeEnd = bookings.lowerEntry(end);
        if (beforeEnd != null && beforeEnd.getValue() > start) {
            return false;
        }
        bookings.put(start, end);
        return true;
    }
}
