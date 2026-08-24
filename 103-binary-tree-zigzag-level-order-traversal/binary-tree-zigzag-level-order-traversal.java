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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root==null){
            return result;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean flag=true;

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> list=new ArrayList<>();

            for(int i=0;i<size;i++){

                TreeNode front=q.poll();

                list.add(front.val);

                if(front.left!=null){
                    q.add(front.left);

                }

                if(front.right!=null){
                    q.add(front.right);
                }
                
                }
                
                if(flag){
                    result.add(list);
                }
                else{
                    Collections.reverse(list);
                    result.add(list);
                }
                flag=!flag;
            }

        return result;
    }
}