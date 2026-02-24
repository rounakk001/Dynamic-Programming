class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
         for(int num:nums){
            sum+=num;
         }
         int k=sum/2;
         boolean dp[][]=new boolean[n][k+1];
         
         
         if(sum%2==1)
         return false;

         for(int i=0;i<n;i++){   //base case if(target)==0 return true;
            dp[i][0]=true;
         }
      // base case: agar first element target ke barabar ho
        if(nums[0] <= k)
         dp[0][nums[0]]=true;                     // if index==0 return a[0]==target


          for(int i=1;i<n;i++){
            for(int target=1;target<=k;target++){
                boolean  nottake=dp[i-1][target];
                //take
                boolean take=false;
                if(target>=nums[i])
                {
                    take=dp[i-1][target-nums[i]];
                }
                dp[i][target]= take || nottake;
            }
          }

          return dp[n-1][k];


    }
}