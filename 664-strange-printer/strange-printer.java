
public class Solution {
    public int strangePrinter(String s) {
        return strangePrinter(0, s.length() - 1, s, new Integer[s.length()][s.length()]);
    }

    private int strangePrinter(int i, int j, String s, Integer[][] dp) {
        if (i == j) return 1;
        if (dp[i][j] != null) return dp[i][j];

        int minTurns = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            minTurns = Math.min(
                minTurns,
                strangePrinter(i, k, s, dp) + strangePrinter(k + 1, j, s, dp)
            );
        }

        return dp[i][j] = (s.charAt(i) == s.charAt(j)) ? minTurns - 1 : minTurns;
    }
}