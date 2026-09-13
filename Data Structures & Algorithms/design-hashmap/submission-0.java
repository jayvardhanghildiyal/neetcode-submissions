class MyHashMap {
    
    class ListNode {
        int key, value;
        ListNode next;

        ListNode (int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // initialize the map
    ListNode[] map;
    public MyHashMap() {
        map = new ListNode[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new ListNode(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        ListNode curr = map[key % 1000];
        while (curr.next != null) {
            // if the key-value pair already exists
            // replace the value 
            if (curr.next.key == key) {
                curr.next.value = value;
                return ;
            }

            // if the value wasn't found
            // move on
            curr = curr.next;
        }

        curr.next = new ListNode (key, value);
    }
    
    public int get(int key) {
        ListNode curr = map[key % 1000];
        while (curr != null) {
            // if the key-value pair exists 
            if (curr.key == key) {
                return curr.value;
            }

            // if the value wasn't found
            // move on
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        ListNode curr = map[key % 1000];
        while (curr.next != null) {
            // if we find the key-value pair
            // remove it
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return ;
            }

            // if the value wasn't found
            // move on
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */