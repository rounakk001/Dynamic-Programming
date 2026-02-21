class Solution {
    public int countones(String s){
        int c=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
            c++;
        }
        return c;
    }
    public boolean isPrime(int n){
    if(n<=1)return false;
    for(int i=2;i*i<=n;i++){
        if(n%i==0)return false;
    }
    return true;
}
    public int countPrimeSetBits(int left, int right) {
        int d=0;
        for(int i=left;i<=right;i++){
            String s=Integer.toBinaryString(i);
            int t=countones(s);
            if(isPrime(t))
            d++;
            else
            continue;
        }
        return d;
    }
}