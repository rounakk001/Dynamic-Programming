class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;

         for(int i=0;i<nums.length;i++){
            int t=sum(nums[i]);
            if(t<min)
            min=t;
        
         }
         return min;
         
    }

    public int sum(int x){
      
            int sum=0;
         while(x!=0){
            int t=x%10;
            sum+=t;
            x=x/10;
         }
         return sum;
    }

}