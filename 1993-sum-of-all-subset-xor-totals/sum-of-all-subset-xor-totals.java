class Solution {
    public int helper(int idx,int sum ,int[] nums,int n){
        if(idx==n){
            return sum;
        }

        //include 
        int  withelement=helper(idx+1,sum^nums[idx],nums,n);

        //exclude
        int  withoutelement=helper(idx+1,sum,nums,n);

        return withelement+withoutelement;

    }
    public int subsetXORSum(int[] nums) {
        return helper(0,0,nums,nums.length);
    }
}