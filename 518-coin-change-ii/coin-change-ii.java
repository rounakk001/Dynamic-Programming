class Solution {
    int dp[][];

    public int solve(int ind,int target,int coins[]){

        if(ind==0){
            if(target % coins[0] == 0)
            return 1;
            else
            return 0;
        }

        if(dp[ind][target]!=-1)
        return dp[ind][target];

        int nottake = solve(ind-1,target,coins);

        int take = 0;

        if(coins[ind]<=target)
        take = solve(ind,target-coins[ind],coins);

        return dp[ind][target]=nottake + take;
    }

    public int change(int amount, int[] coins) {

        dp=new int[coins.length][amount+1];

        for(int i=0;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j]=-1;
            }
        }

        return solve(coins.length-1,amount,coins);
    }
}