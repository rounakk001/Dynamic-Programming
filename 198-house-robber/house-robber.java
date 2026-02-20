class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int prev=nums[0];  //base case ind==0 to arr[0]
        int prev2=0;
        int curri=0;
         int take=0;
         int nottake=0;
        
        for(int i=1;i<n;i++){
            //take i
            take=nums[i];
            if(i>1)
            take=nums[i]+prev2;

            //not take i
            nottake=0+prev;
             
             curri=Math.max(take,nottake);
             prev2=prev;
             prev=curri;
            
        }
        return prev;
    }
}