class Solution {
    int dp[][];

    public int solve(int ind,int target,int coins[]){

        if(ind==0){
            if(target % coins[0] == 0)
            return target/coins[0];
            else
            return (int)1e9;
        }

        if(dp[ind][target]!=-1)
        return dp[ind][target];

        int nottake=solve(ind-1,target,coins);

        int take=(int)1e9;

        if(coins[ind]<=target)
        take = 1+solve(ind,target-coins[ind],coins);

        return dp[ind][target]=Math.min(take,nottake);
    }

    public int coinChange(int[] coins, int amount) {

        dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }

        int ans = solve(coins.length-1,amount,coins);

        if(ans>=(int)1e9) 
            return -1;

        return ans;
    }
}