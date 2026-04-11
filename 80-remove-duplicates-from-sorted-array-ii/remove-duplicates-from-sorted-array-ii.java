class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;

            // count occurrences in result part
            for (int j = 0; j < k; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                }
            }

            // allow only if less than 2 times
            if (count < 2) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}