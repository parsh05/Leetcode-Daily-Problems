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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums ) hs.add( num );
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            if(hs.contains(curr.val) ){
                prev.next = curr.next;
                //prev = prev.next;
                 curr = prev.next;
            }
            else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}