import java.util.*;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int currentValue = 0;

        // Initial F(0)
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            currentValue += i * nums[i];
        }

        int max = currentValue;

        // Your rotation logic idea, but optimized mathematically
        // Instead of physically rotating, update next rotation value directly
        for (int i = 1; i < n; i++) {
            currentValue = currentValue + totalSum - n * nums[n - i];
            max = Math.max(max, currentValue);
        }

        return max;
    }
}