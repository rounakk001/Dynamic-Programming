class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        int[] points = new int[max + 1];
        for (int num : nums)
            points[num] += num;  

        int prev = 0;
        int prev2 = 0;

        for (int i = 0; i <= max; i++) {
            int take = points[i] + prev2;
            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}