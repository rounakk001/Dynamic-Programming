class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        int right=0;
        int[] count=new int[26];
        int maxlen=0;

        while(right<s.length()){
             count[s.charAt(right)-'a']++;
             while(count[s.charAt(right)-'a']>2){
                
                count[s.charAt(left)-'a']--;
                left++;
             }
             maxlen=Math.max(maxlen,right-left+1);
             right++;
        }
        return maxlen;
    }
}