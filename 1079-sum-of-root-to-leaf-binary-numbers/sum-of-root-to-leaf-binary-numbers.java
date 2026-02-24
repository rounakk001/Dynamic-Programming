/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
          return dfs(root,"");
    }
    public int dfs(TreeNode root,String path){
             if(root==null)
             return 0;

             path=path+root.val;

             //check kro leaf node hai kya-> to iska matlab path pura ho gaya hhai convert kr do
             if(root.left==null && root.right==null){
                int number=Integer.parseInt(path,2);
                return number;
             }

             //add kr do left aur right

             return dfs(root.left,path)+dfs(root.right,path);
            
    }
}