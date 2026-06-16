class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // the lambda expression creates a max heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] output = new int[nums.length - k + 1];
        int idx = 0;


        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[]{nums[i], i});

            // after first few element have been added
            if (i >= k - 1) {

                // this while loop checks if the highest element exists outside the sliding window
                while (heap.peek()[1] <= i - k) {
                    // pop all the highest numbers outside the sliding window
                    heap.poll();
                }

                // idx is just a pointer that is post incremented to add to the answer array
                output[idx++] = heap.peek()[0];
            }
        }
        return output;
    }
}
