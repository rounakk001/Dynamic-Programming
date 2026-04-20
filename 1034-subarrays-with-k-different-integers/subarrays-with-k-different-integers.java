class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    public int helper(int nums[],int k){
        int l=0,r=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;

        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);

            while(map.size()>k){
                map.put(nums[l],map.get(nums[l])-1);

                if(map.get(nums[l])==0)
                map.remove(nums[l]);

                l++;
            }

            cnt+=r-l+1;
            r++;
        }

        return cnt;
    }
}