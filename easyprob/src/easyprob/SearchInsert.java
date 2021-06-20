package easyprob;

public class SearchInsert {

	public int searchInsert(int[] nums, int target) {
        //binary search O(logn)
        //return location of last check+1
        
        int location=-1;
        
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            
            if(nums[mid]==target){
                return mid;
            }
            
            if(left==right){
                if(nums[left]>target){ //left of first element
                    return left;
                } else {
                   return left+1; 
                }
                
            }
            
            if(nums[mid]>target){
                //move right
                right = mid-1;
            } else {
                //move left
                left = mid+1;
            }
        }
        
        return left;
    }
}
