class Solution {
    public boolean isMatch(String s, String p) {
        int i = p.length();
        int j = s.length();

        int dp[][] = new int[i][j]; 

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return helper(i - 1, j - 1, p, s, dp);
    }

    public boolean helper(int i, int j, String s1, String s2, int[][] dp) {

        // base cases
        if (i < 0 && j < 0) return true;

        if (i < 0 && j >= 0) return false;

        if (j < 0 && i >= 0) {
            for (int ii = 0; ii <= i; ii++) {
                if (s1.charAt(ii) != '*') return false;
            }
            return true;
        }

        // memoization check
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }

        if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            dp[i][j] = helper(i - 1, j - 1, s1, s2, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }

        if (s1.charAt(i) == '*') {
            boolean res = helper(i - 1, j, s1, s2, dp)|| helper(i, j-1,s1,s2,dp);
            dp[i][j] = res ? 1 : 0;
            return res;
        }

        dp[i][j] = 0;
        return false;
    }
}