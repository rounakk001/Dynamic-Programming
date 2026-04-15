class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int forwardDist = Math.abs(i - startIndex);
                int backwardDist = n - forwardDist;
                minDist = Math.min(minDist, Math.min(forwardDist, backwardDist));
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}