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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currpath=new ArrayList<>();

        dfs(root,targetSum,currpath);
        return result;
    }

    public void dfs(TreeNode root,int targetsum,List<Integer> currpath){
        if(root==null){
            return ;
        }

        currpath.add(root.val);

        targetsum-=root.val;

        if(root.left==null && root.right==null){
            if(targetsum==0){
                result.add(new ArrayList<>(currpath));
            }
            
        }
        else{
             dfs(root.left,targetsum,currpath);
                dfs(root.right,targetsum,currpath);
        }
        
        currpath.remove(currpath.size()-1);

    }
}