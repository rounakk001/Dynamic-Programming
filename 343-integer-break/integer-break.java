class Solution {

    public int integerBreak(int n) {
        int dp[]=new int[n+1];

        Arrays.fill(dp,-1);

        return helper(n,dp);
        
    }

    public int helper(int n,int dp[]){

        if(n==2)
        return 1;
 
        if(dp[n]!=-1)  return dp[n];

        int ans=0;

        for(int i=1;i<n;i++){
            
            ans=Math.max(ans,Math.max(i*(n-i),i*helper(n-i,dp)));
        }
        return dp[n]=ans;
    }
}