import java.util.*;

class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    int findPar(int node) {
        if (node == parent.get(node))
            return node;

        int ulp = findPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void unionByRank(int u, int v) {
        int pu = findPar(u);
        int pv = findPar(v);

        if (pu == pv)
            return;

        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        } else {
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {

    public boolean isValid(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        // Step 1: Connect all existing 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int newr = i + dr[k];
                    int newc = j + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int node = i * n + j;
                        int adjNode = newr * n + newc;

                        ds.unionByRank(node, adjNode);
                    }
                }
            }
        }

        int max = 0;

        // Step 2: Convert each 0 to 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1)
                    continue;

                HashSet<Integer> set = new HashSet<>();

                for (int k = 0; k < 4; k++) {
                    int newr = i + dr[k];
                    int newc = j + dc[k];

                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        set.add(ds.findPar(newr * n + newc));
                    }
                }

                int totalSize = 1;

                for (int parent : set) {
                    totalSize += ds.size.get(parent);
                }

                max = Math.max(max, totalSize);
            }
        }

        // Edge Case: All 1s
        for (int i = 0; i < n * n; i++) {
            max = Math.max(max, ds.size.get(ds.findPar(i)));
        }

        return max;
    }
}