class Solution {

    public int dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        int count = 1;

        for(int n : adj.get(node)){
            if(!vis[n]){
                count += dfs(n, adj, vis);
            }
        }
        return count;
    }

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;

        // graph banayenge
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) 
        adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) 
                continue;

                long x1 = bombs[i][0], y1 = bombs[i][1], r = bombs[i][2];
                long x2 = bombs[j][0], y2 = bombs[j][1];

                long dx = x1 - x2;
                long dy = y1 - y2;

                // distance check krna laude
                if(dx*dx + dy*dy <= r*r){
                    adj.get(i).add(j);
                }
            }
        }

        int maxans = 0;

        for(int i = 0; i < n; i++){
            boolean[] vis = new boolean[n];
            maxans = Math.max(maxans, dfs(i, adj, vis));
        }

        return maxans;
    }
}