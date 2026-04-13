import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();

        // dp[i][j] = result for s[0..i-1], p[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(n, m, s, p, dp);
    }

    private boolean f(int i, int j, String s, String p, int[][] dp) {
        // both empty
        if (j == 0) return i == 0;

        // string empty, pattern non-empty
        if (i == 0) {
            // pattern should be like a*b*c*
            if (p.charAt(j - 1) == '*') {
                return f(i, j - 2, s, p, dp);
            }
            return false;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;

        if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
            ans = f(i - 1, j - 1, s, p, dp);
        } else if (p.charAt(j - 1) == '*') {
            // ignore (0 times)
            boolean notTake = f(i, j - 2, s, p, dp);

            // take (if previous matches)
            boolean take = false;
            if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                take = f(i - 1, j, s, p, dp);
            }

            ans = notTake || take;
        } else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}