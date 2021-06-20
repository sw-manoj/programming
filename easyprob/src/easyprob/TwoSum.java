package easyprob;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
        int result[] = {-1, -1};
        
        for(int i = 0 ; i < numbers.length; i++)
        {
        	if(numbers[i] > target)
        	{
        		continue;
        	}
        	int first = target - numbers[i];
        	
        	for(int j = i+1; j < numbers.length;j++)
        	{
        		if(first == numbers[j])
        		{
        			result[0] =  i+1;
        			result[1] = j+1;
        			return result;
        		}
        	}
        }
        return result;
    }
}
