class Solution {
    
    int[][][] dp;
 
    int m, n;

    public int maxPathScore(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        

        dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = Integer.MIN_VALUE;
                }
            }
        }

        int ans = helper(m-1,n-1,0,grid,k);

        return ans<0?-1:ans;
    }

    public int helper(int i, int j, int cost, int[][] grid,int k) {

        if (i<0||j<0) {
            return -1;
        }

        int add = (grid[i][j] != 0)?1:0;

        if (cost+add>k) {
            return -1;
        }

        if (dp[i][j][cost] != Integer.MIN_VALUE) {
            return dp[i][j][cost];
        }

        if (i == 0 && j == 0) {
            return grid[i][j];
        }

        int up = helper(i - 1, j, cost + add, grid,k);
        int left = helper(i, j - 1, cost + add, grid,k);

        int best = Math.max(up, left);

        if (best == -1) {
            return dp[i][j][cost] = -1;
        }

        return dp[i][j][cost] = best + grid[i][j];
    }
}