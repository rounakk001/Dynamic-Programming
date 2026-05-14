class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int baselength=max+1;
        int base[]=new int[n];

        for(int i=0;i<n;i++){
            if(i<n-2)
            base[i]=i+1;
        }
       Arrays.sort(nums);
       boolean flag=true;

        if(n!=baselength)
        return false;
        else
        {
            for(int i=0;i<=max;i++){
                if(i!=max){
                if(nums[i]!=i+1)
                flag=false;
                }
                else
                if(nums[i]!=max)
                flag=false;
            }
        }
        return flag;
    }
}