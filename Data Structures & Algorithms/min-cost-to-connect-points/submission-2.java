class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];

                int mDist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.computeIfAbsent(i, key -> new ArrayList<>()).add(new int[]{mDist, j});
                adj.computeIfAbsent(j, key -> new ArrayList<>()).add(new int[]{mDist, i});
            }
        }

        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0 , 0}); // the cost and the index that we are at right now

        while (visited.size() < n) {
            int[] state = minHeap.poll();
            int cost = state[0];
            int node = state[1];

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);
            sum += cost;

            for (int[] nei : adj.getOrDefault(node, new ArrayList<>())) {
                int cost1 = nei[0], node1 = nei[1];
                minHeap.offer(new int[]{cost1, node1});
            }
        }

        return sum;
    }
}
