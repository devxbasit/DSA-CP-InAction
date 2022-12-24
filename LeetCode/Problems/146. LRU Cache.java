class LRUCache {
    
    int capacity;
    Deque<Integer> deque;
    Map<Integer, Integer> hm;
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        deque = new LinkedList<>();
        hm = new HashMap<Integer, Integer>();
        
    }
    
    public int get(int key) {
        
        if (!hm.containsKey(key)) return -1;
        
        return hm.get(key);
        
    }
    
    public void put(int key, int value) {
        
       
        if (hm.containsKey(key)) {
            
            System.out.println("remove key" + key);
            deque.remove(key);
        System.out.println(hm);
            
            
        } else if (deque.size() == capacity) { 
            
            int lastKey = deque.removeLast();
            System.out.println("last keuy" + lastKey);
            
            hm.remove(lastKey);
            
        } 
        
        
        deque.addFirst(key);
        hm.put(key, value);
                
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */