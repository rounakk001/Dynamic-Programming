import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxlen = 0;
        int n = s.length();

        // Poora logic ek hi clear while loop mein
        while (right < n) {
            char current = s.charAt(right);

            if (!set.contains(current)) {
                // Case 1: Agar character naya hai, toh window mein shamil karo
                set.add(current);
                maxlen = Math.max(maxlen, right - left + 1);
                right++; // Window ko right se bada kiya
            } else {
                // Case 2: Agar duplicate mila, toh left se characters hatao
                set.remove(s.charAt(left));
                left++; // Window ko left se chota kiya
            }
        }

        return maxlen;
    }
}
