class pair {
    long distance;
    int node;

    pair(long distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    int mod = 1000000007;

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new pair(roads[i][2], roads[i][1]));
            adj.get(roads[i][1]).add(new pair(roads[i][2], roads[i][0]));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.distance, y.distance));

        int[] ways = new int[n];
        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new pair(0L, 0));

        while (!pq.isEmpty()) {
            long distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (distance > dist[node]) continue;

            for (pair itr : adj.get(node)) {
                int adjNode = itr.node;
                long distneighbor = itr.distance;

                if (distance + distneighbor < dist[adjNode]) {
                    dist[adjNode] = distance + distneighbor;
                    ways[adjNode] = ways[node];
                    pq.add(new pair(dist[adjNode], adjNode));
                } 
                else if (distance + distneighbor == dist[adjNode]) {
                    ways[adjNode] = (int)(((long) ways[adjNode] + ways[node]) % mod);
                }
            }
        }

        return ways[n - 1];
    }
}