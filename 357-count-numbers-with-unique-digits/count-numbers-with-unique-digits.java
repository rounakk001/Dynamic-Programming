class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;

        var result = 10;
        var current = 9;

        for (var i = 2; i <= n; i++) {
            current *= (10 - (i - 1));
            result += current;
        }
        return result;
    }
}