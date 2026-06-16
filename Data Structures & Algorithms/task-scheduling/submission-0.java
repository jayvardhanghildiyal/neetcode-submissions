class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char c : tasks) {
            freq[c - 'A'] += 1;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : freq) {
            if (i > 0) {
                maxHeap.add(i);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time += 1;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            } else {
                int num = maxHeap.poll() - 1;
                if (num > 0) {
                    q.add(new int[] {num, time + n});
                }
            }

            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;

    }
}
