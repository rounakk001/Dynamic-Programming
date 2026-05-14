class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n=prices.length;
         dp=new int[n][2][3];
        for(int row[][]:dp){
            for(int roww[]:row){
                Arrays.fill(roww,-1);
            }
        }
        return helper(0,1,2,prices);
    }
    public int helper(int ind,int buy,int cap,int prices[]){
        if(cap==0) return 0;

        if(ind==prices.length) return 0;
        if(dp[ind][buy][cap]!=-1) return dp[ind][buy][cap];

        if(buy==1)
        return dp[ind][buy][cap]=Math.max(-prices[ind]+helper(ind+1,0,cap,prices),0+helper(ind+1,1,cap,prices));

        return dp[ind][buy][cap]=Math.max(prices[ind]+helper(ind+1,1,cap-1,prices),0+helper(ind+1,0,cap,prices));
    }
}