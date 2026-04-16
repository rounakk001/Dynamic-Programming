class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        
        int n = nums.length;
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
 
        List<Integer> answer = new ArrayList<>();
 
        for (int q : queries) {
            List<Integer> indices = indexMap.get(nums[q]);
 
            if (indices.size() == 1) {
                answer.add(-1);
                continue;
            }
 
            // Binary search for position of q in the sorted indices list
            int pos = Collections.binarySearch(indices, q);
            int size = indices.size();
            int minDist = Integer.MAX_VALUE;
 
            // Check neighbor to the right (wrap around if needed)
            int rightIdx = indices.get((pos + 1) % size);
            int d1 = Math.abs(q - rightIdx);
            minDist = Math.min(minDist, Math.min(d1, n - d1));
 
            // Check neighbor to the left (wrap around if needed)
            int leftIdx = indices.get((pos - 1 + size) % size);
            int d2 = Math.abs(q - leftIdx);
            minDist = Math.min(minDist, Math.min(d2, n - d2));
 
            answer.add(minDist);
        }
 
        return answer;
    }
}