class MyCircularDeque {
    static class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }

        Node() {
        }
        // Node(int val, Node next, Node prev){
        // this.next = next;
        // this.val = val;
        // this.prev = prev;
        // }
    }

    private int maxSize = 0, currSize = 0;
    private Node head, last;

    public MyCircularDeque(int k) {
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (currSize >= maxSize)
            return false;
        if (currSize == 0) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
            last = head;
        } else {
            Node curr = new Node(value);
            curr.next = head;
            curr.prev = last;
            head.prev = curr;
            head = curr;
        }
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (currSize >= maxSize)
            return false;
        if (currSize == 0) {
            head = new Node(value);
            head.next = head;
            head.prev = head;
            last = head;
        } else {
            Node curr = new Node(value);
            curr.prev = last;
            curr.next = head;
            last.next = curr;
            last = curr;
        }
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (currSize == 0)
            return false;
        last.next = head.next;
        head.next.prev = last;
        head = head.next;
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (currSize == 0)
            return false;
        last = last.prev;
        last.next = head;
        head.prev = last;
        currSize--;
        return true;
    }

    public int getFront() {
        return head.val;
    }

    public int getRear() {
        return last.val;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize >= maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */