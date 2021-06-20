package easyprob;

public class ReverseWords {
	
	
	public static void main(String[] args) {
		ReverseWords obj = new ReverseWords();
		System.out.println(obj.reverseWords("leetcode my job"));
	}
	public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        
        for(int i = 0 ; i < strArr.length ; i++)
        {
        	
        	System.out.println(strArr[i]);
        	strArr[i] = reverse(strArr[i]);
        }
        
        
        return String.join(" ", strArr);
    }
	
	private String reverse(String s)
	{
		char[] arr = s.toCharArray();
		int n = arr.length-1;
		for(int i = 0 ; i < arr.length/2 ;i++)
		{
			char temp = arr[i];
			arr[i] = arr[n-i];
			arr[n-i] = temp;
			
		}
		return String.copyValueOf(arr);
	}

}
