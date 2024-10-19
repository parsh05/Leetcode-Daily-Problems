class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        linkedMap = new LinkedHashMap<>();
    }

    public int get(int key) {
        if(linkedMap.containsKey(key)){
            int value = linkedMap.get(key);
            linkedMap.remove(key);
            linkedMap.putLast(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(linkedMap.containsKey(key)){
            linkedMap.remove(key);
            linkedMap.putLast(key, value);
        } else{
            if(linkedMap.size() == cap) linkedMap.pollFirstEntry();
            linkedMap.putLast(key, value);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */