class KthLargest {

    PriorityQueue<Integer> q;
    int j;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        j = k;
        for (int i : nums) {
            if (q.size() < j){
                q.add(i);
            } else if (i > q.peek()) {
                q.poll();
                q.add(i);
            }
        }
    }
    
    public int add(int val) {
        if (q.size() < j){
            q.add(val);
        } else if (val > q.peek()) {
            q.poll();
            q.add(val);
        }

        return q.peek();
    }
}
