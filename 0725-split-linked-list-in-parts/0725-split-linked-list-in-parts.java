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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        int length = 0;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        int minLength = length / k;
        int rem = length % k;

        curr = head;
        for(int i = 0; i < k; i++){
            int size = minLength;
            if(rem > 0){
                size++;
                rem--;
            }
            ans[i] = new ListNode(-1, null);
            ListNode prev = ans[i];
            for(int j = 1; j <= size; j++){
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
            prev.next = null;
            ans[i] = ans[i].next;
        }
        return ans;
    }
}