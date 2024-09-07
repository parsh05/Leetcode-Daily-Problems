class Solution {

    // Helper method to check if there is a subpath starting from the current TreeNode
    public boolean matchPath(TreeNode root, ListNode currNode) {
        if (currNode == null) return true;  // Linked list is fully traversed
        if (root == null) return false;     // Binary tree path ends before the list
        if (root.val != currNode.val) return false;  // Values don't match
        
        // Continue checking the subpath in both left and right subtrees
        return matchPath(root.left, currNode.next) || matchPath(root.right, currNode.next);
    }
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false; // No more tree nodes to check
        
        // Check if the linked list starts from the current root or any of its children
        return matchPath(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}
