class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    Node(){}
}

class LRUCache {
    int capacity;
    Node head, tail;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            addAtfirst(head, node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            // remove from its position, update the value and then add key to the first
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // add at first
             // add newNode to first
                // node.prev = head;
                // node.next = head.next;
                // head.next.prev = node;
                // head.next = node;
                addAtfirst(head, node);
                node.value = value;
        } else{
            Node newNode = new Node(key, value);
            if(map.size() == capacity){
                // remove last Node from last position
                    map.remove(tail.prev.key);
                    tail.prev = tail.prev.prev;
                    tail.prev.next = tail;

                // add newNode to first
                addAtfirst(head, newNode);
            
                map.put(key, newNode);
            } else{
                // add to the first position
                // newNode.prev = head;
                // newNode.next = head.next;
                // head.next.prev = newNode;
                // head.next = newNode;
                addAtfirst(head, newNode);
                map.put(key, newNode);
            }
        }
        
    }
     void addAtfirst(Node head, Node newNode){
                newNode.prev = head;
                newNode.next = head.next;
                head.next.prev = newNode;
                head.next = newNode;
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */