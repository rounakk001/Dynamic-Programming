
class Solution {
    public boolean findSafeWalk(List<List<Integer>> adj, int health) {
        int dx[] = { 1, -1, 0, 0 };
        int dy[] = { 0, 0, 1, -1 };

        int n = adj.size();
        int m = adj.get(0).size();

        int dist[][] = new int[n][m];

        for (int row[] : dist) {
            Arrays.fill(row, -1);
        }

        int initialhealth = health - adj.get(0).get(0);

        if (initialhealth < 0) {
            return false;
        }

        Queue<int[]> q = new LinkedList<>();

        dist[0][0] = initialhealth; //health grid is dist[][]

        q.add(new int[] { 0, 0, initialhealth });

        while (!q.isEmpty()) {
            int curr[] = q.poll();

            int currH = curr[2];
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = dx[i] + r;
                int nc = dy[i] + c;

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int remainingHealth = currH - adj.get(nr).get(nc);

                    if (remainingHealth <= 0)
                        continue;

                    if (remainingHealth > dist[nr][nc]) {
                        dist[nr][nc] = remainingHealth;
                        q.offer(new int[] { nr, nc, remainingHealth });
                    }

                }

            }
        }
        if (dist[n - 1][m - 1] > 0) {
            return true;
        } else {
            return false;
        }
    }
}