class Solution {
    public int helper(int i,int j1,int j2,int[][][] dp,int [][] grid)
    {
        int m=grid[0].length;
        int n=grid.length;
        //base case out of bound
        if(j1<0 || j1>=m || j2<0 || j2>=m){
            return (int)(-1e9);
        }
        //base case reach destination
        if(i==n-1){
            if(j1==j2) return grid[i][j1];  //column same
            else  return grid[i][j1]+grid[i][j2]; //column different dono ko add krenge
        }

        if(dp[i][j1][j2]!=-1)
        return dp[i][j1][j2];

        
       int maxi=(int)(-1e9);
        for(int dj1=-1;dj1<=1;dj1++){
            for(int dj2=-1;dj2<=1;dj2++){
                 if(j1==j2) maxi=Math.max(maxi,grid[i][j1]+helper(i+1,dj1+j1,dj2+j2,dp,grid));
                 else
                 maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+helper(i+1,dj1+j1,dj2+j2,dp,grid));
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n][m][m];

        for(int row[][]:dp){
            for(int roww[]:row){
                Arrays.fill(roww,-1);
            }
        }
        //helper(i,j1,j2);
        return helper(0,0,m-1,dp,grid);
    }
}