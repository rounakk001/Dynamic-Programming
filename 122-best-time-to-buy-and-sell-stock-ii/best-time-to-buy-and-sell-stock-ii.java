class Solution {
    
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return helper(0,1,prices,dp); //starting day me to buy kr hi skte hai 
    }

    public int helper(int ind,int buy,int prices[],int dp[][]){
            if(ind==prices.length)
            return 0;

            int profit=0;

            if(dp[ind][buy]!=-1) return dp[ind][buy];

            if(buy==1){  //buy ka option hai
                profit=Math.max(-prices[ind]+helper(ind+1,0,prices,dp),helper(ind+1,1,prices,dp)); 
                //pehle me hum buy kr rahe to paise lg rahe to -prices[ind] aur doosre me we  thought not to buy 
            }
            else{    //sell ka option hai

                 profit=Math.max(prices[ind]+helper(ind+1,1,prices,dp),helper(ind+1,0,prices,dp)); 
            }
            return dp[ind][buy]=profit;
    }
}