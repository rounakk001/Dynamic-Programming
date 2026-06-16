class Solution {
    public String processStr(String s) {
        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                answer.append(ch);
            } else if (ch == '*') {
                if (answer.length() > 0) {
                    answer.deleteCharAt(answer.length() - 1);
                }
            } else if (ch == '#') {
                answer.append(answer.toString());
            } else {
                answer.reverse();
            }
        }

        return answer.toString();
    }
}