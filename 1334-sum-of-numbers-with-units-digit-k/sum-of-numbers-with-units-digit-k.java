class Solution {
    public int minimumNumbers(int num, int k) {
        if(num == 0) return 0;
        int n = k;
        int r1 = num%10;
           int r2 = n%10;
           if(r1 == r2) return 1;
           if(r2 == 0) return -1;
        int ans = 1;
        while(n <= num) {
           r1 = num%10;
         r2 = n%10;
           if(r1 == r2) break;
           ans++;
           n+= k;
        }
        if(n > num) return -1;
        return ans;
    }
}