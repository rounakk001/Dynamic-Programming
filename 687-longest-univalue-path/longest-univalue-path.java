class Solution {
    int maxcount = 0;

    public int longestUnivaluePath(TreeNode root) {
        maxlength(root);
        return maxcount;
    }

    public int maxlength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Pehle dono subtrees se longest chain lao
        int left = maxlength(root.left);
        int right = maxlength(root.right);

        int leftPath = 0;
        int rightPath = 0;

        // Agar left child same value ka hai
        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }

        // Agar right child same value ka hai
        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }

        // Current node ko beech me rakhkar complete path
        maxcount = Math.max(maxcount, leftPath + rightPath);

        // Parent ko sirf ek direction return karni hai
        return Math.max(leftPath, rightPath);
    }
}