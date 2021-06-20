package sequence;

public class SubSeqEasy {
//	https://leetcode.com/problems/is-subsequence/
	
public boolean isSubsequence(String s, String t) {
		int lb = s.length(), rb = t.length();
		int l = 0, r = 0;
		
		while(l < lb && r < rb)
		{
			if(s.charAt(l) == t.charAt(r))
			{
				l++;
			}
			r++;
		}
		return l == lb;
    }
}
