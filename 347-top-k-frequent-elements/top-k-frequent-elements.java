import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Use a HashMap for frequency counting (O(1) access is faster than TreeMap)
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert Map entries to a List to sort them
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort the list based on values (frequencies) in descending order
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());

        // Extract the top K keys
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }
}
