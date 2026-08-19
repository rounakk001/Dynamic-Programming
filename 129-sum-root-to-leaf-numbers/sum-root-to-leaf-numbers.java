class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,sum);
        return sum;
    }

    public void helper(TreeNode node,int curr){
        if(node==null) return;

        curr = curr*10 + node.val;
        
        if(node.left==null && node.right==null){
            sum += curr;
        }

        helper(node.left,curr);
        helper(node.right,curr); 
    }
}