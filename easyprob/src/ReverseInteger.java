
public class ReverseInteger {
	
	public static void main(String[] args) {
		ReverseInteger revInt = new ReverseInteger();
//		System.out.println(revInt.reverse(123));
//		System.out.println(revInt.reverse(-123));
//		System.out.println(revInt.reverse(120));
		
		// since int max value is 2147483647 , is result is about to cross this limit we return 0 as done below
		System.out.println(Integer.MAX_VALUE + "length " +Integer.toBinaryString(Integer.MAX_VALUE).length());
		System.out.println((Integer.MAX_VALUE/10) + "length " +Integer.toBinaryString(Integer.MAX_VALUE/10).length());
		System.out.println((2147483640 + 7) + "length " +Integer.toBinaryString(2147483640 + 7).length());
		System.out.println((2147483640 + 8) + "length " +Integer.toBinaryString(214748364 + 8).length());
		System.out.println(revInt.reverse(1534236469));
	}

	public int reverse(int x) {
      
		
		int divider = 10;
		int divRes = 0;
		int result = 0;
		
		while (x != 0)
		{
			divRes = x % divider;
			x = x / divider;
	        if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && divRes > 7)) return 0;
	        if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && divRes < -8)) return 0;
			result = (result * divider) + divRes;
		}
		
		return result;
    }

}
