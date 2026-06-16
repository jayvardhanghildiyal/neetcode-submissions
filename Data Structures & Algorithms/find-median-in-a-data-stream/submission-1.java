class MedianFinder {


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    int count;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        count = 0;
    }
    
    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.add(num);
            count += 1;
        } else {
            if (num > minHeap.peek()) {
                minHeap.add(num);
                count += 1;
            } else {
                maxHeap.add(num);
                count += 1;
            }
        }

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (count % 2 == 0) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return maxHeap.peek();
        }
    }
}
