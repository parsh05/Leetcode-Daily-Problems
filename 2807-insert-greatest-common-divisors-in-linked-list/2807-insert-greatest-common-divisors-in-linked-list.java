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
    private int gcd(int a, int b){
        // assuming b >= a
        if(b % a == 0 ) return a;
        return gcd(b%a, a);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode t1 = head, t2 = head.next;
        while( t2 != null ){
            int gcd = (t1.val < t2.val)? gcd( t1.val, t2.val) : gcd(t2.val, t1.val);
            ListNode newNode = new ListNode( gcd );
            t1.next = newNode;
            newNode.next = t2;
            // for next iteration
            t1 = newNode.next;
            t2 = t2.next;
        }
        return head;
    }
}