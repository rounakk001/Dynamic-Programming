class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        int left = 0;
        int right = 0;
        int sum = 0;

        int minLen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        // best[i] = shortest valid subarray ending at or before i
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        while (right < n) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                // Previous subarray must end before 'left'
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            best[right] = minLen;

            right++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}