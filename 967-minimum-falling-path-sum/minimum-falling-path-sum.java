class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int dp[][]=new int[n][m];

          //BASE CASE
          for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
          }
  
          //for every row chala lkin shuru doosri row se shuru krenge
          for(int i=1;i<n;i++){
             int lowerdiagonal=Integer.MAX_VALUE;

             int upperdiagonal=Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                int upper=matrix[i][j]+dp[i-1][j];
        if(j-1>=0) 
         lowerdiagonal=matrix[i][j]+dp[i-1][j-1];
          if(j+1<m)    
            upperdiagonal=matrix[i][j]+dp[i-1][j+1];

                dp[i][j]=Math.min(upper,Math.min(lowerdiagonal,upperdiagonal));
            }
          }

          int min=dp[n-1][0];
          for(int j=0;j<m;j++){
            min=Math.min(min,dp[n-1][j]);
          }
          return min;
    }
}