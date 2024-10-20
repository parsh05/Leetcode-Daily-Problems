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
    public ListNode reverseList(ListNode head) {
        ListNode t1=head,t2=head,temp=null;
        while(t2!=null && t2.next!=null)t2=t2.next;

        while(t1!=null && t1!=t2){
            temp=t2.next;
            t2.next=t1;
            t1=t1.next;
            t2.next.next=temp;
        }
        return t2;
    }
}