class Solution {
    public boolean helper(int idx, int[] nums,int[] dp) {

        if (idx>=nums.length-1)
            return true;

            if(dp[idx]!=0)
            return dp[idx]==1;

        for (int i=1; i<=nums[idx];i++) {

            if (idx+i<nums.length) {
                if (helper(idx+i,nums,dp))
                {    dp[idx]=1;
                    return true;
                }
            }
        }

        dp[idx]=-1;
        return false;
    }

    public boolean canJump(int[] nums) {
        int dp[]=new int[nums.length];
        
        return helper(0,nums,dp);
    }
}