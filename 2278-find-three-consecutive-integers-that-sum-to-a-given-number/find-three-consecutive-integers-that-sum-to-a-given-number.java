class Solution {
    public long[] sumOfThree(long num) {
        long[] res=new long[3];

        if(num%3==0){
            return new long[]{(num/3-1),(num/3),(num/3+1)};
        }
        else{
            return new long[]{};
        }
    }}