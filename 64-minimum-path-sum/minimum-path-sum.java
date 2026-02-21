class Solution {

    public int helper(int i,int j,int dp[][],int grid[][]){

          if(i==0 && j==0)
          return grid[0][0];

          if(i<0 || j<0)
          return Integer.MAX_VALUE;

          if(dp[i][j]!=-1)
          return dp[i][j];

          

          int left=helper(i,j-1,dp,grid);
          int up=helper(i-1,j,dp,grid);

          int min=Math.min(left,up); 
          //ye jaruri hai taaki overflow na ho 
          if(min==Integer.MAX_VALUE)
          return dp[i][j]=Integer.MAX_VALUE;

          return  dp[i][j]=grid[i][j]+min;


    }
    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        int dp[][]=new int[m][n];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return helper(m-1,n-1,dp,grid);
    }
}