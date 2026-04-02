import java.util.*;

class Solution{

    int dp[][][];

    public int cherryPickup(int[][] grid){
        int n=grid.length;

        dp=new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }

        int ans=helper(0,0,0,grid);
        return Math.max(0,ans); //negative case handle
    }

    public int helper(int i1,int j1,int i2,int[][]grid){

        int n=grid.length;
        int j2=i1+j1-i2;

        //out of bounds
        if(i1>=n||j1>=n||i2>=n||j2>=n)
            return -(int)1e9;

        //blocked cell
        if(grid[i1][j1]==-1||grid[i2][j2]==-1)
            return -(int)1e9;

        //destination
        if(i1==n-1&&j1==n-1)
            return grid[i1][j1];

        if(dp[i1][j1][i2]!=Integer.MIN_VALUE)
            return dp[i1][j1][i2];

        int cherries;

        //same cell ek baar add
        if(i1==i2&&j1==j2)
            cherries=grid[i1][j1];
        else
            cherries=grid[i1][j1]+grid[i2][j2];

        //4 moves
        int f1=helper(i1+1,j1,i2+1,grid);
        int f2=helper(i1,j1+1,i2,grid);
        int f3=helper(i1+1,j1,i2,grid);
        int f4=helper(i1,j1+1,i2+1,grid);

        int best=Math.max(Math.max(f1,f2),Math.max(f3,f4));

        return dp[i1][j1][i2]=cherries+best;
    }
}