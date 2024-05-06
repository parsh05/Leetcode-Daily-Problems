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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode t = head;
        while(t!=null){
            if(st.size()==0||t.val<=st.peek().val) st.push(t);
            else if(t.val > st.peek().val ){
                while(st.size()>0 && t.val > st.peek().val ){
                    st.pop();
                }
                st.push(t);
            }
            t=t.next;
        }
        Stack<ListNode> stll = new Stack<>();
        while(st.size()>0){
            stll.push(st.pop());
        }
        ListNode h = new ListNode(-1);
        ListNode t2 = h;
        while(stll.size()>0){
            t2.next = stll.pop();
            t2 = t2.next;
        }
        return h.next;
    }
}