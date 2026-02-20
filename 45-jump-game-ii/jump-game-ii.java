class Solution {

    public int helper(int idx,int nums[],int dp[]){
        int n=nums.length;

        if(idx>=nums.length-1)
          return 0;

          if(dp[idx]!=-1)
          return dp[idx];

          int minsteps=Integer.MAX_VALUE;

          for(int i=1;i<=nums[idx];i++){
            if(idx+i<n){
                int jump=helper(idx+i,nums,dp);
                if(jump!=Integer.MAX_VALUE)  //yahan 0 ke liye minsteps Integer max_value hi rahega kyuki wo update nhi hoga 
                minsteps=Math.min(minsteps,1+jump);
            }
          }
          return dp[idx]=minsteps;

    }
    public int jump(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];

        Arrays.fill(dp,-1);

        return helper(0,nums,dp);
    }
}