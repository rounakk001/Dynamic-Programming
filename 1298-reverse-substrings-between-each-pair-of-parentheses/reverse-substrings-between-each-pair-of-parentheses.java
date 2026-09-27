import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> openBrackets = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                // Store the index of the open bracket
                openBrackets.push(i);
            } 
            else if (sb.charAt(i) == ')') {
                // Get the matching open bracket index
                int start = openBrackets.pop();
                int end = i;

                // Reverse the substring between 'start' and 'end' directly in StringBuilder
                reverseRange(sb, start + 1, end - 1);
            }
        }

        // Finally, remove all brackets from the fully processed string
        return sb.toString().replace("(", "").replace(")", "");
    }

    // Helper method to reverse a specific range inside StringBuilder
    private void reverseRange(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
