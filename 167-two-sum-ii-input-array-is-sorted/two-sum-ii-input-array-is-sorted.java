class Solution {
    public int[] twoSum(int[] nums, int target) {
       int low=0;
       int right=nums.length-1;

       while(low<right){
        int sum=nums[low]+nums[right];
        if(sum==target){
            return new int[]{low+1,right+1};
        }
        else if(sum>target){
            right--;
        }
        else{
            low++;
        }
       }

       return new int[]{-1,-1};
    }
}