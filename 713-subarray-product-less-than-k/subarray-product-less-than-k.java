class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) 
        return 0;

        int l = 0, r = 0, cnt = 0, prod = 1;
        int n = nums.length;

        while (r < n) {
            prod *= nums[r];

            while(prod >= k) {
                prod /= nums[l];
                l++;
            }

            cnt += (r - l + 1);

            r++;
        }

        return cnt;
    }
}
