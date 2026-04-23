class Pair {
    int distance, node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int V, int S) {

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // 1-based indexing → size V+1
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        // build graph
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v); // neighbor
            temp.add(w); // weight

            adj.get(u).add(temp);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new Pair(0, S));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int distance = curr.distance;
            int node = curr.node;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjnode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[adjnode]) {
                    dist[adjnode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjnode], adjnode));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}