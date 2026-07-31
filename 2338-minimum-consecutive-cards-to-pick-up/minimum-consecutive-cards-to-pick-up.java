class Solution {
    public int minimumCardPickup(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], -1);
        }

        int r = 0, n = nums.length;
        int min = Integer.MAX_VALUE;

        while(r < n){

            if(map.get(nums[r]) != -1){
                min = Math.min(min, r - map.get(nums[r]) + 1);
            }

            map.put(nums[r], r);
            r++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}