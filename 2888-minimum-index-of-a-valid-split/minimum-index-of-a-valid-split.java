class Solution {
    public int minimumIndex(List<Integer> nums) {

        int n = nums.size();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxf = Integer.MIN_VALUE;
        int ans = -1;

        for (Integer key : map.keySet()) {
            if (map.get(key) > maxf) {
                maxf = map.get(key);
                ans = key;
            }
        }

        int leftcount = 0;

        for (int i = 0; i < n - 1; i++) {

            if (nums.get(i) == ans) {
                leftcount++;

                if (leftcount * 2 > (i + 1) &&
                    (maxf - leftcount) * 2 > (n - i - 1)) {
                    return i;
                }
            }
        }

        return -1;
    }
}