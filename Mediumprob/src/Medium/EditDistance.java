package Medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/edit-distance/submissions/
public class EditDistance {
	
	//works good
	//cost of actions,
//	insert = 1;
//	delete = 1
//	replace = 1

	public int editDistance(String s, String t)
	{
		int dist = 0;
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		for(int i = s.length()-1; i >=0 ; i--)
		{
			//populating corner case , s to "". insert is needed to get to s from ""
			dp[i][t.length()] = 1 +  dp[i+1][t.length()];
		}
		
		for(int i = t.length()-1; i >=0 ; i--)
		{
			//populating corner case , t to "". insert/delete is needed to get to s from ""

			dp[s.length()][i] = 1 +  dp[s.length()][i+1];
		}
		
		
		
		for(int i = s.length()-1 ; i >= 0 ; i--)
		{
			for(int j = t.length()-1 ; j >= 0 ;j--)
			{
				if(s.charAt(i) == t.charAt(j))
				{
					dp[i][j] = dp[i+1][j+1];
				}
				else
				{
					// three options if not matches, delete given by i, j +1, insert i+1, j, replacement, i+1, j+1
					//i+1, j+1 = replacement
					dp[i][j] = 1 + Math.min(Math.min(dp[i+1][j+1], dp[i+1][j]), dp[i][j+1]);
				}
			}
		}
		
		return dp[0][0];
	}


	public int minDistance(String word1, String word2) {
		return minDistanceHelper(word1, word2, 0, 0, word1.length(), word2.length(), new HashMap<>());
	}

	public int minDistanceHelper(String word1, String word2, int i, int j, int n, int m, Map<String, Integer> memo) {

		if(i >= n) {
			return m-j;
		}
		if(j >= m) {
			return n-i;
		}

		String currentKey = i + "-" + j;
		if(memo.containsKey(currentKey)) {
			return memo.get(currentKey);
		}

		int ans = Integer.MAX_VALUE;
		if(word1.charAt(i) == word2.charAt(j)) {
			ans = minDistanceHelper(word1, word2, i+1, j+1, n,m, memo);
		}
		else {
			int insertOp = minDistanceHelper(word1, word2, i+1, j, n , m ,memo);
			int deleteOp = minDistanceHelper(word1, word2, i, j+1, n , m ,memo);
			int replaceOp = minDistanceHelper(word1, word2, i+1, j+1, n , m ,memo);
			ans = Math.min(ans, 1+ Math.min(insertOp, Math.min(deleteOp, replaceOp)));
		}
		memo.put(currentKey, ans);
		return ans;
	}
	
	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		System.out.println(obj.editDistance("horse", "ros"));
		
		System.out.println(obj.editDistance("abcde", "fghijk"));
		System.out.println(obj.editDistance("abcde", "fgaibk"));
		System.out.println(obj.editDistance("abcde", "agbijk"));

		System.out.println(obj.minDistance("horse", "ros"));

		System.out.println(obj.minDistance("abcde", "fghijk"));
		System.out.println(obj.minDistance("abcde", "fgaibk"));
		System.out.println(obj.minDistance("abcde", "agbijk"));



	}
}
