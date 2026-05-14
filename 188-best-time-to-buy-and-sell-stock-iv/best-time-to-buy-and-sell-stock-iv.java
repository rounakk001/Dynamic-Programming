
class Solution {
    public int maxProfit(int k,int[] prices) {
        int n = prices.length;

        // n+1 because dp[ind+1] access ho raha hai
        int[][][] dp = new int[n + 1][2][k+1];

        // dp[n][buy][cap] = 0 by default
        // cap = 0 means no transactions left => profit 0

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {

                // cap starts from 1
                // cap=0 pe transaction possible nahi
                for (int cap = 1; cap <= k; cap++) {

                    if (buy == 1) {
                        dp[ind][buy][cap] = Math.max(
                                -prices[ind] + dp[ind + 1][0][cap], // Buy
                                dp[ind + 1][1][cap] // Skip
                        );
                    } else {
                        dp[ind][buy][cap] = Math.max(
                                prices[ind] + dp[ind + 1][1][cap - 1], // Sell
                                dp[ind + 1][0][cap] // Skip
                        );
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}