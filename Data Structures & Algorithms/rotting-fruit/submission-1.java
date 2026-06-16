class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int fresh = 0;
        int minutes = 0;
        // add all rotten froot
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh += 1;
                }
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] coords = q.poll();
                int row = coords[0], col = coords[1];

                for (int[] d : directions) {
                    int r = row + d[0], c = col + d[1];
                    if (r >= 0 && r < rows 
                        && c >= 0 && c < cols 
                        && grid[r][c] == 1) {
                            q.add(new int[]{r, c});
                            grid[r][c] = 2;
                            fresh -= 1;
                    }
                }
            }
            minutes += 1;   
        }

        return fresh == 0 ? minutes : -1;
    }
}
