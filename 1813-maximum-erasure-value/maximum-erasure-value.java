class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],-1);
        }

        int l=0;
        int r=0;
        int n=nums.length;
        int maxsum=0;
        int sum=0;
        while(r<n){
            
            if(map.get(nums[r])!=-1){
                while(map.get(nums[r])>=l){
                    sum-=nums[l];
                    l++;
                }
            }
            sum+=nums[r];
            maxsum=Math.max(sum,maxsum);
            map.put(nums[r],r);
            r++;
        }
        return maxsum;
    }
}