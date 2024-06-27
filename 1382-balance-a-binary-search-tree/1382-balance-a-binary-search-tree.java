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
    ArrayList<TreeNode> sortedArr = new ArrayList<>();
    private void toArray(TreeNode root){
        if(root == null ) return ;
        toArray(root.left );
        sortedArr.add( root );
        toArray(root.right);
    }
    private TreeNode balanceBst(ArrayList<TreeNode> sortedArr, int l, int h){
        if( l > h ) return null;
        int idx = l + (h - l)/2;
        TreeNode curr =sortedArr.get(idx);
        curr.left = balanceBst(sortedArr, l, idx - 1);
        curr.right = balanceBst(sortedArr, idx + 1, h); 
        return curr;
    }
    public TreeNode balanceBST(TreeNode root) {
        toArray(root);
        int n = sortedArr.size();
        return balanceBst( sortedArr, 0, n-1);
    }
}