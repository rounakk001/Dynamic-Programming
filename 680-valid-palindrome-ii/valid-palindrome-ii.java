class Solution {
    public boolean isPalindromeRange(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                //ya to hu, left  kr ke dekhenge ki match ho raha baaki ka ki nahi to right wal skip kr ke dekhenge kyuki jaha pe character mismatch hua tha usk age dekhna chaiye ki aage matching to nahi hai
                return isPalindromeRange(s,left+1,right) || isPalindromeRange(s,left,right-1);
            }
            left++;
            right--;
            
        }
        return true;
    }
}