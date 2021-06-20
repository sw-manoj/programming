package easyprob;

public class PalindromeNumber {

	public static void main(String[] args) {
		PalindromeNumber palNum = new PalindromeNumber();
		System.out.println(palNum.isPalindrome(121));
	}
	
	public boolean isPalindrome_opt(int x) {
        if( x < 0 || x % 10 == 0 && x != 0 ) return false;
        int tmp = 0, xSto = x;
        while(x!=0){
            tmp = (tmp * 10) + (x % 10);
            x = x/10;
        }
        return tmp == xSto;
    }
	public boolean isPalindrome(int x) {
		String s = Integer.toString(x);
		System.out.println(s);
		return isPalindrome(s);
    }
	
	public boolean isPalindrome(String str)
	{
		int len = str.length();
		for(int i = 0 ;i < len/2 ;i++)
		{
			if(str.charAt(i) != str.charAt(len - i -1))
			{
				return false;
			}
		}
		return true;
	}

}
