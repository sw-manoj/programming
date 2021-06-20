package easyprob;

public class HappyNumber {

//	https://leetcode.com/problems/happy-number/
	private int squareNum(int num)
	{
		int ans = 0;
		int d;
		while(num > 0)
		{
			d = num % 10;
			num = num/10;
			ans += d*d;
		}
		return ans;
	}
	public boolean isHappy(int n) {
        

		int tort = n;
		int hare = squareNum(n);
//		boolean count = false;
		while(hare != 1 && hare != tort)
		{
			tort = squareNum(tort);
			hare = squareNum(squareNum(hare));
		}
		return hare == 1;
    }
	
	public static void main(String[] args) {
		HappyNumber obj = new HappyNumber();
//		System.out.println(obj.isHappy(19));
		System.out.println(obj.isHappy(2));

	}
}
