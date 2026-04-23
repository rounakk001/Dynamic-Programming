class Pair {
    int distance, node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int findTheCity(int V, int[][] edges, int distanceThreshold) {

        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

       
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // build undirected graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

           
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v); 
            temp.add(w); 
            adj.get(u).add(temp);

           
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(u); 
            temp1.add(w); 
            adj.get(v).add(temp1);
        }

        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;

        // run Dijkstra for every city
        for (int src = 0; src < V; src++) {

            PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[src] = 0;
            pq.add(new Pair(0, src));

            while (!pq.isEmpty()) {
                Pair curr = pq.poll();

                int node = curr.node;
                int distance = curr.distance;

                for (int i = 0; i < adj.get(node).size(); i++) {

                    int adjnode = adj.get(node).get(i).get(0);
                    int edgeWeight = adj.get(node).get(i).get(1);

                    if (distance + edgeWeight < dist[adjnode]) {
                        dist[adjnode] = distance + edgeWeight;
                        pq.add(new Pair(dist[adjnode], adjnode));
                    }
                }
            }

            // count nodes within threshold
            int count = 0;
            for (int i = 0; i < V; i++) {
                if (i != src && dist[i] <= distanceThreshold) {
                    count++;
                }
            }

            // choose minimum, tie → larger index
            if (count <= minCount) {
                minCount = count;
                resultCity = src;
            }
        }

        return resultCity;
    }
}