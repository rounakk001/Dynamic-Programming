class Pair {
    int node, distance;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.distance - b.distance
        );

        boolean[] visited = new boolean[n];

        int totalCost = 0;

        // Start from node 0
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            int cost = current.distance;

            // Already taken in MST
            if (visited[node]) {
                continue;
            }

            // Add this node
            visited[node] = true;
            totalCost += cost;

            // Check all other points
            for (int nextnode = 0; nextnode< n; nextnode++) {

                if (!visited[nextnode]) {

                    int dist =
                        Math.abs(points[node][0] - points[nextnode][0]) +
                        Math.abs(points[node][1] - points[nextnode][1]);

                    pq.add(new Pair(dist, nextnode));
                }
            }
        }

        return totalCost;
    }
}