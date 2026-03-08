class Solution {
    public int fun(int i,int num[],int or,int k){
        if(i==num.length){
            if(or==k){
                return 1;
            }
            return 0;
        }
        int x=fun(i+1,num,(or|num[i]),k);
        int y=fun(i+1,num,or,k);
        return x+y;
    }
    public int countMaxOrSubsets(int[] nums) {
        int k=0;
        for(int ele:nums){
            k=k|ele;
        }
        return fun(0,nums,0,k);
    }
}