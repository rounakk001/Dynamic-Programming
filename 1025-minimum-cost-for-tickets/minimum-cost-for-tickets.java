class Solution {
    int dp[];

    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        dp=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return solve(0, days, costs);
    }

    public int solve(int ind, int[] days, int[] costs) {

        int n = days.length;

        // saare travel days cover ho gaye
        if (ind >= n) {
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }

        //Buy 1 day pass
        int cost1 = costs[0] + solve(ind + 1, days, costs);


       // Buy 7 day pass
        int i = ind;

        while (i < n && days[i] < days[ind] + 7) {
            i++;
        }

        int cost2 = costs[1] + solve(i, days, costs);


        //Buy 30 day pass
        int j = ind;

        while (j < n && days[j] < days[ind] + 30) {
            j++;
        }

        int cost3 = costs[2] + solve(j, days, costs);


        return dp[ind]=Math.min(cost1, Math.min(cost2, cost3));
    }
}