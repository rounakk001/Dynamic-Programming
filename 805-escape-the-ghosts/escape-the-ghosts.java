class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Integer.MAX_VALUE;

        for (int ghost[] : ghosts) {
            int x = ghost[0];
            int y = ghost[1];

            dist = Math.min(dist, (Math.abs(target[0] - x) + Math.abs(target[1] - y)));
        }

        if (dist > (Math.abs(target[0] - 0) + Math.abs(target[1] - 0)))
            return true;
        else
            return false;
    }
}