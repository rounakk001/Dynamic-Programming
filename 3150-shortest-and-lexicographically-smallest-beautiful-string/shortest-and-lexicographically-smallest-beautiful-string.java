class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0, r = 0;
        int minl = -1, minr = -1;
        int n = s.length();
        int cnt = 0;
        int minlen = Integer.MAX_VALUE;

        while (r < n) {
            if (s.charAt(r) == '1') {
                cnt++;
            }

            // Jab k se zyada 1s ho jayein, shrink karo
            while (cnt > k) {
                if (s.charAt(l) == '1') {
                    cnt--;
                }
                l++;
            }

            // Jab exactly k ones hain extra leading 0s hatao
            while (cnt == k && s.charAt(l) == '0') {
                l++;
            }

            if (cnt == k) {
                int len = r - l + 1;

                if (len < minlen ||
                    (len == minlen &&
                     s.substring(l, r + 1)
                      .compareTo(s.substring(minl, minr + 1)) < 0)) {

                    minlen = len;
                    minl = l;
                    minr = r;
                }
            }

            r++;
        }

        if (minl == -1) return "";

        return s.substring(minl, minr + 1);
    }
}