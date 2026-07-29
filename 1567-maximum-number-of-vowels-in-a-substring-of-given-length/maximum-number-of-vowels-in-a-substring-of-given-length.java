class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxlen = 0;
        int vowelcount = 0;

        
        while (right < n) {
            
            char rightChar = s.charAt(right);

            if (rightChar == 'a' || rightChar == 'e' || rightChar == 'i' || rightChar == 'o' || rightChar == 'u') {
                vowelcount++;
            }

           
            if (right - left + 1 == k) {
                maxlen = Math.max(maxlen, vowelcount);

                
                char leftChar = s.charAt(left);
                if (leftChar == 'a' || leftChar == 'e' || leftChar == 'i' || leftChar == 'o' || leftChar == 'u') {
                    vowelcount--;
                }
                left++; 
            }

            right++; 
        }

        return maxlen;
    }
}
