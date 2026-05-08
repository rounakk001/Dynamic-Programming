class DisjointSet {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findpar(int node) {
        if (parent.get(node) == node)
            return node;

        int ulp = findpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionbyrank(int u, int v) {
        int ulp_u = findpar(u);
        int ulp_v = findpar(v);

        if (ulp_u == ulp_v)
            return;

        if (rank.get(ulp_u) < rank.get(ulp_v))
            parent.set(ulp_u, ulp_v);
        else if (rank.get(ulp_v) < rank.get(ulp_u))
            parent.set(ulp_v, ulp_u);
        else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DisjointSet ds = new DisjointSet(n);

        // matrix traverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // agar connected hai aur same node nahi hai
                if (isConnected[i][j] == 1 && i != j) {
                    ds.unionbyrank(i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (ds.findpar(i) == i) {  //no of ultimate parent hi number of provinces honge
                count++;
            }
        }

        return count;
    }
}