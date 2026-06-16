class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for (int[] t : times) {
            edges.computeIfAbsent(t[0], 
            key -> new ArrayList<>()).add(new int[]{t[1], t[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();

        int t = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int dist = curr[0], node = curr[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            t = dist;

            if (edges.containsKey(node)) { // check if node goes somewhere (wont be key if it)
                for (int[] nei : edges.get(node)) {
                    int node1 = nei[0], dist1 = nei[1];
                    if (!visited.contains(node1)) {
                        minHeap.offer(new int[]{dist1 + dist, node1});
                    }
                }
            }
        }
        return visited.size() == n ? t : -1;
    }
}
