class Solution {
    public int minimumOneBitOperations(int n) {
        int m=1;
        int res=0;
        while(n>0) {
            res+=n^(n-1)*m;
            m=-1 * m;
            n&=n-1;
        }
        return Math.abs(res);
    }
}