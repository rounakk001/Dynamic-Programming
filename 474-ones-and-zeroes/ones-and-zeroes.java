class Solution {

    int dp[][][];

    public int solve(String strs[],int ind,int m,int n){
        //base case
        if(ind<0)
        {
            return 0;
        }

        if(dp[ind][m][n]!=-1)
        return dp[ind][m][n];

        int zeroes=0,ones=0;

        for(char c:strs[ind].toCharArray()){
            if(c=='0')
            zeroes++;
            else
            ones++;
        }

        int nottake=0+solve(strs,ind-1,m,n);

        int take=0;

        if(zeroes<=m && ones<=n)
        take=1+solve(strs,ind-1,m-zeroes,n-ones);

        return dp[ind][m][n]=Math.max(take,nottake);

    }

    public int findMaxForm(String[] strs, int m, int n) {

        dp=new int[strs.length][m+1][n+1];

        for(int i=0;i<strs.length;i++)
        for(int j=0;j<=m;j++)
        for(int k=0;k<=n;k++)
        dp[i][j][k]=-1;

        return solve(strs,strs.length-1,m,n);
    }
}