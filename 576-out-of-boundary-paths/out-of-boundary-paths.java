//easyyyyy check kr jaha all paths ya possibilities hai waha fatafat recursion soch uske baad memoize
//yaha teen cheez ho rahi hai naa maxmove aur i aur j to  ho hhi raha hai change
class Solution {
    int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {             
          int dp[][][]=new int[maxMove+1][m][n];

          for(int arr[][]:dp){
            for(int arrr[]:arr){
                Arrays.fill(arrr,-1);
            }
          }
          return helper(startRow,startColumn,maxMove,m,n,dp);
    }


    public int helper(int i,int j,int max,int rows,int cols,int[][][] dp){
        
        if(i>=rows || i<0 || j<0 || j>=cols)
        return 1;
        if(max==0)
        return 0;
         
         if(dp[max][i][j]!=-1)
         return dp[max][i][j];        //4 possibliities cosider kr  right up down left

        int d=0;

    
         d=(d+helper(i,j+1,max-1,rows,cols,dp))%mod;

        d=(d+helper(i-1,j,max-1,rows,cols,dp))%mod;

        d=(d+helper(i+1,j,max-1,rows,cols,dp))%mod;

        d=(d+helper(i,j-1,max-1,rows,cols,dp))%mod;

        return dp[max][i][j]=d%mod;
    }
}