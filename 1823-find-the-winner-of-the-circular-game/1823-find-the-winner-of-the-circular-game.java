class Solution {
    public int findTheWinner(int n, int k) {
        if(k==1) return n;
        Node head = new Node(1);
        Node t = head;
       for(int i=2;i<=n;i++){
        t.next = new Node(i);
        t = t.next;
       }
       t.next = head;

    int steps = 0;
    Node h = new Node(0);
    h.next = head;
    t = h;
       while(t.next != t){
            if(steps==k-1) {
                t.next = t.next.next;
                steps=0;
            }
            else {
                steps++;
                t = t.next;
            }
        
       }
       return t.data;
    }
    
}
class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}