class Solution {
    public void dfs(int row,int col,int[][] vis,char[][] board){
        int n=board.length;
        int m=board[0].length;

        vis[row][col]=1;

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='X'){
                dfs(nrow,ncol,vis,board);
            }
        }
    }
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        int vis[][]=new int[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && board[i][j]=='X'){
                    c++;
                dfs(i,j,vis,board);
                }
            }
        }
        return c;
    }
}