class Solution {

    public int minFlips(String s) {

        int n = s.length();
        String str = s + s;

        StringBuilder alt1 = new StringBuilder();
        StringBuilder alt2 = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            alt1.append(i % 2 == 0 ? '0' : '1');
            alt2.append(i % 2 == 0 ? '1' : '0');
        }

        int diff1 = 0, diff2 = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < str.length(); right++) {

            if (str.charAt(right) != alt1.charAt(right)) diff1++;
            if (str.charAt(right) != alt2.charAt(right)) diff2++;

            if (right - left + 1 > n) {

                if (str.charAt(left) != alt1.charAt(left)) diff1--;
                if (str.charAt(left) != alt2.charAt(left)) diff2--;

                left++;
            }

            if (right - left + 1 == n) {
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}