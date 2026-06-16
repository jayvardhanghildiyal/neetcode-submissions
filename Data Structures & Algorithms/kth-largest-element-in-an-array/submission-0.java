class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : nums) {
            if (q.size() == k && i > q.peek()) {
                q.poll();
                q.add(i);
            } else if (q.size() < k){
                q.add(i);
            }
        }

        return q.poll();
    }
}
