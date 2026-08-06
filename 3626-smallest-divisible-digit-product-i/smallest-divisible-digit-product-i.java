class Solution {
    public int prod(int n){
        int prod=1;
        int x=n;
        while(x!=0){
            prod*=x%10;
            x=x/10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            int x=prod(i);
            if(x%t==0){
                return i;
            }
        }
        return 0;
    }
}