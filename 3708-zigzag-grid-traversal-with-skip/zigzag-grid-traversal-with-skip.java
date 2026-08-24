class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        // true means add the element, false means skip it
        boolean keep = true; 
        
        for (int i = 0; i < n; i++) {
            // Even rows: left to right
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    if (keep) {
                        list.add(grid[i][j]);
                    }
                    keep = !keep; // Alternate every single cell
                }
            } 
            // Odd rows: right to left
            else {
                for (int j = m - 1; j >= 0; j--) {
                    if (keep) {
                        list.add(grid[i][j]);
                    }
                    keep = !keep; // Alternate every single cell
                }
            }
        }
        return list;
    }
}



