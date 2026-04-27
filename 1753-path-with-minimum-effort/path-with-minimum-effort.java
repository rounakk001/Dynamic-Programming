class tuple {
    int first, second, third;

    tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<tuple> q = new PriorityQueue<tuple>((x, y) -> (x.first - y.first));

        q.add(new tuple(0, 0, 0));

        int nr[] = { -1, 0, 1, 0 };
        int nc[] = { 0, 1, 0, -1 };

        int[][] dist = new int[n][m];

        for (int arr[] : dist) {
            Arrays.fill(arr, (int) (1e9));
        }

        dist[0][0] = 0;

        while (!q.isEmpty()) {

            int currdiff = q.peek().first;
            int row = q.peek().second;
            int col = q.peek().third;

            if (row == n - 1 && col == m - 1)
                return currdiff;

            q.remove();

            for (int i = 0; i < 4; i++) {
                int newrow = row + nr[i];
                int newcol = col + nc[i];

                if (newrow < n && newrow >= 0 && newcol < m && newcol >= 0) {
                    int diff = Math.abs(heights[row][col] - heights[newrow][newcol]);

                    int neweffort = Math.max(diff, currdiff);
                    
                    if (dist[newrow][newcol] > neweffort) {
                        dist[newrow][newcol] = neweffort;
                        q.add(new tuple(neweffort, newrow, newcol));
                    }
                }
            }

        }
        return 0;

    }
}