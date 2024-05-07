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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode t = head;
        int carry = 0;
        while(t!=null){ ;
            int val = t.val*2 + carry;
            t.val =(val )%10;
            carry = (val)/10;
            if(t.next==null && carry!=0){
                t.next = new ListNode(carry);
                break;
            }
            t = t.next;
        }
       // if(carry!=0) t = new ListNode(carry);
        return reverse(head);
    }
    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}