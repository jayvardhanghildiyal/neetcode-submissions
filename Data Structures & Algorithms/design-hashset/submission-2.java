// linked list
class MyHashSet {

    class ListNode {
        int key;
        ListNode next;

        ListNode (int key) {
            this.key = key;
        }
    }

    ListNode[] set;

    public MyHashSet() {
        // these 10000 array spots will act as linked list heads
        // that allow us to quickly find a number based on the hash
        // key % 10000
        set = new ListNode[10000];
        for (int i = 0; i < 10000; i++) {
            set[i] = new ListNode(-1);
        }
    }
    
    public void add(int key) {
        ListNode curr = set[key % 10000];
        // basically going downwards
        // traversing down the linked list instead forwards (laterally) with the array
        while (curr.next != null) {
            // check if the number already exists
            // if so, don't add it and return
            if (curr.next.key == key) {
                return ;
            }

            curr = curr.next;
        }

        curr.next = new ListNode(key);
    }
    
    public void remove(int key) {
        ListNode prev = set[key % 10000];
        ListNode curr = prev.next;

        while (curr != null) {
            // remove the key
            if (curr.key == key) {
                prev.next = curr.next ;
                curr.next = null;
                return ;
            }

            // move onwards
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        ListNode curr = set[key % 10000];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */