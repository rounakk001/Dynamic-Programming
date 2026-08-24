class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        return Math.min(left, right) + 1;
    }
}