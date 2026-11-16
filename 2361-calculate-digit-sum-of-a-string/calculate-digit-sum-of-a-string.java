
class Solution {

    public String digitSum(String s, int k) {

        while (s.length() > k) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i += k) {

                String t = s.substring(i, Math.min(i + k, s.length()));

                int sum = 0;

                for (int j = 0; j < t.length(); j++) {
                    sum += t.charAt(j) - '0';
                }

                sb.append(sum);
            }

            s = sb.toString();
        }

        return s;
    }
}
