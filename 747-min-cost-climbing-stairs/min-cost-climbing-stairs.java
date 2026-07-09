class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];

        Arrays.fill(dp,-1);

        return Math.min(solve(0,cost),solve(1,cost));
    }

    public int solve(int ind,int cost[]){
        
        int n=cost.length;
        //base case
        if(ind>=n){
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }

        int step1= cost[ind]+solve(ind+1,cost);

        int step2=cost[ind]+solve(ind+2,cost);

        return dp[ind]=Math.min(step1,step2);
    }
}