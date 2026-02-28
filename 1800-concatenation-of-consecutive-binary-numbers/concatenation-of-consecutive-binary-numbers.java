class Solution {
    int mod = 1000000007;

    public int concatenatedBinary(int n) {
        long result=0;

        for (int i=1;i<=n;i++) {

            String s=Integer.toBinaryString(i);

            for (int j=0;j<s.length();j++) {
                result=(result*2 +(s.charAt(j) - '0'))%mod;
            }
        
        }

        return (int)(result);
    }
}
