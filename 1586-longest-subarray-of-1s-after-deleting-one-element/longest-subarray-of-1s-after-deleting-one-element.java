class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int right=0;
        int count=0;
        int maxlen=0;
        int n=nums.length;

        while(right<n){

            if(nums[right]==0){
                count++;
            }

            while(count>1){
                if(nums[left]==0){
                    count--;
                }
                left++;
            }
            maxlen=Math.max(right-left+1,maxlen);
            right++;
        }
        return maxlen-1;
    }
}