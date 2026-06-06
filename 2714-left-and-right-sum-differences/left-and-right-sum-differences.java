class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sumleft[]=new int[nums.length];
         int sumright[]=new int[nums.length];
         sumleft[0]=0;
         sumright[nums.length-1]=0;

         int suml=0;
       int  sumr=0;

        for(int i=0;i<nums.length-1;i++){
            suml+=nums[i];
            
            sumleft[i+1]=suml;
       }
       for(int i=nums.length-1;i>0;i--){
        sumr+=nums[i];
        sumright[i-1]=sumr;
       }
       int diff[]=new int[nums.length];
       for(int i=0;i<diff.length;i++){
        diff[i]=Math.abs(sumright[i]-sumleft[i]);
       }
       return diff;
        
    }
}