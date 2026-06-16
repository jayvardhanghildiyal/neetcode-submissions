class Solution {
    public int inf = 2147483647;
    public int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    bfs(i, j, grid);
                }
            }
        }
    }

    public void bfs(int row, int col, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] coords = q.poll();
            int r = coords[0], c = coords[1];
            // steps += 1; cant use this. when queue comes back to an earlier position, the steps number would have become very large from all the iterations.
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 
                    && nr < grid.length && nc < grid[0].length 
                    && grid[nr][nc] != -1 && grid[nr][nc] > grid[r][c] + 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = grid[r][c] + 1;
                }
            }
        }
    }

    public void dfs (int row, int col, int[][] grid, int steps, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length 
            || col >= grid[0].length || grid[row][col] == -1) {
            return ;
        // glaring red flag ! have to recheck visited places again (kinda defeats the purpose)
        } else if (visited[row][col] == true && grid[row][col] > steps) {
            grid[row][col] = steps;
        } else if (visited[row][col] == true) {
            return ;
        }

        visited[row][col] = true;
        if (grid[row][col] > steps) {
            grid[row][col] = steps;
        }
        for (int[] d : directions) {
            int r = row + d[0], c = col + d[1];
            dfs(r, c, grid, steps + 1, visited);
        }
    }
}
