class Solution {
    StringBuilder sb = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();

        dfs(root, path);

        return path;
    }

    public void dfs(TreeNode root, List<String> path) {
        if (root == null) {
            return;
        }

        // Store current length for backtracking
        int length = sb.length();

        // Add current node
        sb.append(root.val);

        // If leaf node, add complete path
        if (root.left == null && root.right == null) {
            path.add(sb.toString());
        } else {
            // Add arrow only if there are more nodes ahead
            sb.append("->");

            dfs(root.left, path);
            dfs(root.right, path);
        }

        // Backtrack: restore StringBuilder to its previous state
        sb.setLength(length);
    }
}