class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return count(nums,goal) - count(nums,goal-1);

    }

    public int count(int[] nums,int goal){

        if(goal<0) return 0;
        int n=nums.length;
        int l=0,r=0,cnt=0;
        int sum=0;

        while(r<n){
            sum+=nums[r];
            
            while(sum>goal){
              
              sum-=nums[l];
              l++;
            }
            cnt+=(r-l+1);
           r++;
        }
        return cnt;
    }
}