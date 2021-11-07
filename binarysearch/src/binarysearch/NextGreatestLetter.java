package binarysearch;

public class NextGreatestLetter {

//	https://leetcode.com/problems/find-smallest-letter-greater-than-target/submissions/
	public static void main(String[] args) {
		NextGreatestLetter obj = new NextGreatestLetter();
		System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f','j' } , 'c'));
		System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f','j' } , 'a'));
		System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f','j' } , 'j'));
		System.out.println(obj.nextGreatestLetter(new char[] {'c', 'f','j' } , 'g'));
		System.out.println(obj.nextGreatestLetter(new char[] {'c', 'c', 'c', 'c', 'c', 'f','j' } , 'c'));



	}
	public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int n = letters.length-1;
        int end = n;
        
        while(start <= end)
        {
        	int mid = start + (end - start)/2;
        	
//        	if(letters[mid] == target)
//        	{
//        		return mid == n ? letters[0] : letters[mid+1];
//        	}
        	
        	if(letters[mid] > target)
        	{
        		end = mid -1;
        	}
        	else
        	{
        		start = mid+1;
        	}
        }
        
        return letters[start % letters.length];
    }
}
