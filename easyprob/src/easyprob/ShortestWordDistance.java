package easyprob;

public class ShortestWordDistance {

	public static void main(String[] args) {
		
	}
	
	public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDist = wordsDict.length;
        int index1 = -1;
        int index2 = -1;
        
        for(int i = 0 ; i < wordsDict.length; i++)
        {
        	if(wordsDict[i].equals(word1))
        	{
        		index1 = i;
        	}
        	else if(wordsDict[i].equals(word2))
        	{
        		index2 = i;
        	}
        	
        	
        	if(index1 != -1 && index2 != -1)
        	{
        		minDist = Math.min(minDist, (Math.abs(index2-index1)));
        	}
        	
        	if(minDist == 1)
        	{
        		return minDist;
        	}
        }
        
        return minDist;
    }
}
