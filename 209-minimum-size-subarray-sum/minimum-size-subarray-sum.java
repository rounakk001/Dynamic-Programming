class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
         int sum=0;
         int min=Integer.MAX_VALUE;
         int n=nums.length;
         boolean flag=false;
        while(r<n){
            sum+=nums[r];

         while(sum>=target){
             if(r-l+1<min){
             min=r-l+1;
              flag=true;
             }
             
            sum-=nums[l];
            l++;
             

         }
         
         r++;
         
         
        }
        if(flag==false)
        return 0;
        else
        return min;
    }
}