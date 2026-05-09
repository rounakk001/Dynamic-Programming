class Solution {
    public int minFlips(String s) {
        int n = s.length();

        if (n <= 2) {
            return 0;
        }

        int ones = 0;

        // Count total number of '1's
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        int zeroes = n - ones;

        // Count interior ones (excluding first and last character if they are '1')
        int interiorOnes = ones;
        if (s.charAt(0) == '1') {
            interiorOnes--;
        }
        if (s.charAt(n - 1) == '1') {
            interiorOnes--;
        }

        int t = 0;

        // Check if first and last are '0'
        if (s.charAt(0) == '0') {
            t++;
        }
        if (s.charAt(n - 1) == '0') {
            t++;
        }

        t += interiorOnes;

        return Math.min(zeroes, Math.min(Math.max(ones - 1, 0), t));
    }
}