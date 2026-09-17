class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        StringBuilder stack = new StringBuilder(); // Using StringBuilder as a simple stack
        
        // Loop from 0 to pattern.length() inclusive to handle the last digit
        for (int i = 0; i <= pattern.length(); i++) {
            // Push the current digit (1-indexed based on position)
            stack.append(i + 1);
            
            // If we hit 'I' or reached the end of the pattern, pop everything
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                result.append(stack.reverse());
                stack.setLength(0); // Clear the stack for the next sequence
                            }
        }
        
        return result.toString();
    }
}
