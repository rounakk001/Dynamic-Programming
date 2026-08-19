class Solution {
    StringBuilder sb = new StringBuilder();
    ArrayList<String> path = new ArrayList<>();

    public String smallestFromLeaf(TreeNode root) {
        dfs(root);
        Collections.sort(path);
        return path.get(0);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        // Save current StringBuilder length
        int length = sb.length();

        // Add current character
        sb.append((char) ('a' + root.val));

        // If leaf, create leaf -> root string
        if (root.left == null && root.right == null) {
            path.add(new StringBuilder(sb).reverse().toString());
        }

        dfs(root.left);
        dfs(root.right);

        // Backtracking
        sb.setLength(length);
    }
}