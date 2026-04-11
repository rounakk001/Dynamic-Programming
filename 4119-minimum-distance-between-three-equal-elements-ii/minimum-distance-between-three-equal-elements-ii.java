class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // store indices
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int min = Integer.MAX_VALUE;

        // compute distance using abs formula
        for (ArrayList<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int a = list.get(i);
                    int b = list.get(i + 1);
                    int c = list.get(i + 2);

                    int dist = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);

                    min = Math.min(min, dist);
                }
            }
        }

        if(min==Integer.MAX_VALUE)
        return -1;
        else
        return min;
    }
}