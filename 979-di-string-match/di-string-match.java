class Solution {
    public int[] diStringMatch(String s) {
        int n=s.length();   
        int perm[]=new int[n+1];
        int cstart=0;
        int cend=n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
            perm[i]=cstart;
            cstart++;
            }
            if(s.charAt(i)=='D'){
            perm[i]=cend;
            cend--;
            }
        }
        if(s.charAt(s.length()-1)=='I'){
            perm[n]=perm[n-1]+1;
        }
        else{
            perm[n]=perm[n-1]-1;
        }
        return perm;
    }
}