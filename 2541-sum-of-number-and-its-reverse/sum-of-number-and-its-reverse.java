class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++) {
            int reverse=0;
            int temp=i;

            while(temp > 0) {
                int digit=temp%10;
                reverse=reverse*10+digit;
                temp/=10;
            }

            if(i+reverse==num) {
                return true;
            }
        }

        return false;

    }
}