class Solution {
    long mod = 1000000007;
    int[][][] dp;

    public int numberOfPaths(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    dp[i][j][r] = -1;
                }
            }
        }

        return helper(m - 1, n - 1, 0, grid, k);
    }

    public int helper(int i, int j, int rem, int[][] grid, int K) {
        if (i < 0 || j < 0)
            return 0;

        // direct remainder update 
        //newSum % k = (oldSum + grid[i][j]) % k = (rem + grid[i][j]) % k
        
        rem = (rem + grid[i][j]) % K;

        if (i == 0 && j == 0) {
            return rem == 0 ? 1 : 0;
        }

        if (dp[i][j][rem] != -1)
            return dp[i][j][rem];

        int up = helper(i - 1, j, rem, grid, K);
        int left = helper(i, j - 1, rem, grid, K);

        return dp[i][j][rem] = (int) ((up + left) % mod);
    }
}