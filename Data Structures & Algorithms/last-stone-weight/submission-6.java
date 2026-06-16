class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i : stones) {
            q.add(-i);
        }

        while (q.size() > 1) {
            int one = q.poll();
            int two = q.poll();

            if (two - one > 0) {
                q.add(one - two);
            }
        }

        return q.size() == 1 ? Math.abs(q.poll()) : 0;
    }
}
