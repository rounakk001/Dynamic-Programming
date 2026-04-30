class pair {
    int distance, node;

    pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist1 = new int[n + 1]; // shortest
        int[] dist2 = new int[n + 1]; // second shortest

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(0, 1));
        dist1[1] = 0;

        while (!q.isEmpty()) {
            pair curr = q.poll();

            int steps = curr.distance;
            int node = curr.node;

            for (int adjNode : adj.get(node)) {

                int newSteps = steps + 1;
                // Agar newSteps sabse chhota path hai
                if (newSteps < dist1[adjNode]) {

                    // Purana shortest ab second shortest ban jayega
                    dist2[adjNode] = dist1[adjNode];

                    // Naya shortest update karo
                    dist1[adjNode] = newSteps;

                    // BFS me push karo further explore ke liye
                    q.add(new pair(newSteps, adjNode));
                }

                // Agar newSteps shortest se bada hai but second shortest se chhota hai
                else if (newSteps > dist1[adjNode] && newSteps < dist2[adjNode]) {

                    // Second shortest update karo
                    dist2[adjNode] = newSteps;

                    // Isko bhi explore karna zaroori hai
                    q.add(new pair(newSteps, adjNode));
                }
            }
        }

        int totalTime = 0;

        // dist2[n] matlab destination tak second shortest path me kitni edges lagenge
        for (int i = 0; i < dist2[n]; i++) {

            // Agar signal red hai toh rukna padega
            // Even block = green, Odd block = red
            if ((totalTime / change) % 2 == 1) {

                // Next green signal aane tak wait karo
                totalTime = ((totalTime / change) + 1) * change;
            }

            // Ab signal green hai, toh next edge cross karo
            totalTime += time;
        }

        // Ye final second minimum time hoga
        return totalTime;
    }
}