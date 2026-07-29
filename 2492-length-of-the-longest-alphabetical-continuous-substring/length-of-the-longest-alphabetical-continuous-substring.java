class Solution {
    public int longestContinuousSubstring(String s) {
        int left = 0;
        int n = s.length();
        int len = 0;
        
        while (left < n) {
            int count = 1;
            
           
            while (left + 1 < n && s.charAt(left) + 1 == s.charAt(left + 1)) {
                count++;
                left++; 
            }
            
            len = Math.max(len, count);
            left++; 
        }
        
        return len;
    }
}
