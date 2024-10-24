/**
 * Definition for a binary tree TreeNode.
 * public class TreeTreeNode {
 *     int val;
 *     TreeTreeNode left;
 *     TreeTreeNode right;
 *     TreeTreeNode() {}
 *     TreeTreeNode(int val) { this.val = val; }
 *     TreeTreeNode(int val, TreeTreeNode left, TreeTreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean dfs(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null || root1.val != root2.val) return false;
        
        if(root1.left != null && root2.right!= null && root1.left.val == root2.right.val){
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }

        if(root1.right != null && root2.left!= null && root1.right.val == root2.left.val){
            TreeNode temp = root1.right;
            root1.right = root1.left;
            root1.left = temp;
        }
        
        return dfs(root1.left, root2.left) && dfs(root1.right , root2.right);
    }
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }
}