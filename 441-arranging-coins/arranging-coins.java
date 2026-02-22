class Solution {
    public int arrangeCoins(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
             
           count+=1;
           n=n-count;
            if(n<=i)
           break;
          
           
        }
        return count;
    }
}