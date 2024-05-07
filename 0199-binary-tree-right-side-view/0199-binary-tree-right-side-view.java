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
    List<Integer> ans = new LinkedList<>();
    int height = -1 ;
    public List<Integer> rightSideView(TreeNode root) {
        func(root,-1);
        return ans;
    }
    void  func(TreeNode root,int currHeight){
        if(root==null) return ;
        currHeight++;
        if(currHeight > height){
            ans.add(root.val);
            height = currHeight;
        }
        func(root.right,currHeight);
        func(root.left,currHeight);
    }
}