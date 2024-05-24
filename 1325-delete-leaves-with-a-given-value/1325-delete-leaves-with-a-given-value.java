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
    boolean canRemove(TreeNode root, int target){
        if(root == null) return true;
        boolean flag = false;
        if(root.val == target) flag = true;
        boolean canRemoveLeft = canRemove(root.left, target);
        if(canRemoveLeft == true) root.left = null;
        boolean canRemoveRight = canRemove(root.right, target);
        if(canRemoveRight == true) root.right = null;
        return flag && canRemoveLeft && canRemoveRight;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean flag = canRemove(root, target);
        if(flag == true ) return null;
        return root;
    }
}