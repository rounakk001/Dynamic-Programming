class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> lastSeen = new HashMap<>(); // maps reversed value -> last index stored
        int minDist = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            int rev = reverseNum(nums[j]);

            // Check if current number was stored as a reverse of some earlier number
            if (lastSeen.containsKey(nums[j])) {
                minDist = Math.min(minDist, j - lastSeen.get(nums[j]));
            }

            // Store the reversed value of nums[j] -> j
            lastSeen.put(rev, j);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int reverseNum(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}