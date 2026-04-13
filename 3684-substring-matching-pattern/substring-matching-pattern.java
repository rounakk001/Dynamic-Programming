class Solution {
    public boolean hasMatch(String s, String p) {

        int star = p.indexOf('*');

        String left = p.substring(0, star);
        String right = p.substring(star + 1);

        int n = s.length();

        for (int i = 0; i <= n - left.length(); i++) {

            // match left
            if (!match(s, i, left)) 
            continue;

            // match right after left
            int start = i + left.length();

            for (int j = start; j <= n - right.length(); j++) {
                if (match(s, j, right)) return true;
            }
        }

        return false;
    }

    boolean match(String s, int start, String t) {
        for (int k = 0; k < t.length(); k++) {
            if (s.charAt(start + k) != t.charAt(k)) 
            return false;
        }
        return true;
    }
}