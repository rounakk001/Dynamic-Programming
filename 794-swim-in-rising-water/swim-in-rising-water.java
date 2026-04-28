import java.util.*;

class tuple {
    int first, second, third;

    tuple(int first, int second, int third) {
        this.first = first;   // time till now
        this.second = second; // row
        this.third = third;   // col
    }
}

class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<tuple> q = new PriorityQueue<>((x, y) -> x.first - y.first);

        q.add(new tuple(grid[0][0], 0, 0));

        int[] nr = { -1, 0, 1, 0 };
        int[] nc = { 0, 1, 0, -1 };

        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        while (!q.isEmpty()) {

            int currTime = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;

            q.remove();

            // destination reached
            if (row == n - 1 && col == n - 1)
                return currTime;

            for (int i = 0; i < 4; i++) {

                int newrow = row + nr[i];
                int newcol = col + nc[i];

                if (newrow >= 0 && newrow < n && newcol >= 0 && newcol < n
                        && !vis[newrow][newcol]) {

                    int newTime = Math.max(currTime, grid[newrow][newcol]);

                    vis[newrow][newcol] = true;
                    q.add(new tuple(newTime, newrow, newcol));
                }
            }
        }

        return 0;
    }
}