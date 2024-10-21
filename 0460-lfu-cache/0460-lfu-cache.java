import java.util.HashMap;

class Node {
    int key;
    int val;
    Node prev;
    Node next;
    int useCount; // Frequency counter

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.useCount = 1;
    }
    Node() {}
}

class DLL {
    Node head;
    Node tail;

    DLL() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addAtFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public Node removeLast() {
        if (isEmpty()) return null;
        Node lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
}

public class LFUCache {
    int capacity;
    int minFreq;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        int freq = node.useCount;
        
        // Remove node from current frequency list
        freqMap.get(freq).removeNode(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) minFreq++;
        }

        // Update node's frequency
        node.useCount++;
        addAtFirst(node, node.useCount);

        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return; // No capacity means nothing to store

        if (map.containsKey(key)) {
            // Update existing node
            Node node = map.get(key);
            node.val = value;
            get(key);  // Update frequency via the `get` method
        } else {
            if (map.size() == capacity) {
                // Remove the least frequently used node (LFU), and if ties, LRU
                DLL minFreqDLL = freqMap.get(minFreq);
                Node lfuNode = minFreqDLL.removeLast();
                map.remove(lfuNode.key);
                if (minFreqDLL.isEmpty()) freqMap.remove(minFreq);
            }

            // Create new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            minFreq = 1;  // New nodes are always added with frequency 1
            addAtFirst(newNode, 1);
        }
    }

    private void addAtFirst(Node node, int freq) {
        if (!freqMap.containsKey(freq)) {
            freqMap.put(freq, new DLL());
        }
        freqMap.get(freq).addAtFirst(node);
    }
}
