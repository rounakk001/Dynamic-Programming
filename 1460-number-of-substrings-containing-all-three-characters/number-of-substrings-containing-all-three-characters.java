class Solution {
    public int numberOfSubstrings(String s) {
        int l=0;
        int r=0;
        int n=s.length();
        int count[]=new int[n];
        int ans=0;
        while(r<n){
            {
                count[s.charAt(r)-'a']++;
                while(count[0]>=1 && count[1]>=1 && count[2]>=1){
                    ans+=(n-r);
               
                count[s.charAt(l++)-'a']--;
                
                }
               
                r++;
                
            }
        }
        return ans;
    }
}