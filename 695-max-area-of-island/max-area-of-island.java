class Solution {
    public int dfs(int row,int col,int area,int[][] grid,int[][] vis){

        int n=grid.length;
        int m=grid[0].length;

        vis[row][col]=1;

        area=1;

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        for(int i=0;i<4;i++){

            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                area+=dfs(nrow,ncol,0,grid,vis);
            }
        }
            return area;
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;


        int vis[][]=new int[n][m];

        
        int maxarea=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0)
                maxarea=Math.max(maxarea,dfs(i,j,0,grid,vis));
            }
        }

       return maxarea;
    }
}