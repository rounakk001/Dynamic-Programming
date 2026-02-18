class Solution {
    public int solve(int i,int[] dp,int[] costs,int  n){

        //base case
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];  //already computed ke liye dekh rahe

        int ans=Integer.MAX_VALUE;

        //ab jump try karenge

        for(int jump=1;jump<=3;jump++){

            int j=i+jump;
            if(j<=n){
            int totalcost=costs[j-1]+jump*jump+solve(j,dp,costs,n);
            
            ans=Math.min(ans,totalcost);
            }
        }
        dp[i]=ans;  ///jb n value ho jayegi tab value return  krna chalu hoga pehle dp[3] me zero hoga phir dp[2] pgir dp[1]  phir akhiri me dp[0] wahi answer hooga
        return ans;
    }
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
       int ans= solve(0,dp,costs,n);
       return ans;
    }
}