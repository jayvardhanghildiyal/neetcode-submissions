class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int answer = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0}); // time, x, y
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int t = node[0], x = node[1], y = node[2];
            if (x == n - 1 && y == n - 1) {
                answer = t;
                break;
            }
            visited.add(grid[x][y]);
            for (int[] d : directions) {
                int x1 = x + d[0], y1 = y + d[1];
                if (x1 >= n || y1 >= n || x1 < 0 || y1 < 0 || visited.contains(grid[x1][y1])) {
                    continue;
                }
                if (grid[x1][y1] <= t) {
                    minHeap.offer(new int[]{t, x1, y1});
                } else if (grid[x1][y1] > t) {
                    minHeap.offer(new int[]{grid[x1][y1], x1, y1});
                }
            }
        }

        return answer;
    }
}
