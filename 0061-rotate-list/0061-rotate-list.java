/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // get total no of nodes
        if( k == 0 || head == null || head.next == null ) return head;
        int size = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            size++;
        }
        k = k % size; // since it is rotation and k might be greater than size
        if( size == 0) return head;
        ListNode t1 = head, t2 = head;
        while( k-- > 0) t1 = t1.next;

        while( t1.next != null ){
            t2 = t2.next;
            t1 = t1.next;
        }
        ListNode newHead = t2.next;
        t2.next = null;
        t1.next = head;
        return newHead;
    }
}