class Solution {

    public int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int r = grid.length, c = grid[0].length;
        int islands = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands += 1;
                }
            }
        }

        return islands;
    }

    public void dfs (char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || 
            c >= grid[0].length || grid[r][c] == '0') {
                return ;
        }

        grid[r][c] = '0';
        for (int[] d : directions) {
            dfs(grid, r + d[0], c + d[1]);
        }
    }

    public void bfs (char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] n = q.poll();
            int nr = n[0], nc = n[1];

            for (int[] d : directions) {
                int dr = nr + d[0], dc = nc + d[1];

                if (dr >= 0 && dc >= 0 && dr < grid.length && 
                    dc < grid[0].length && grid[dr][dc] == '1') {
                        q.add(new int[]{dr, dc});
                        grid[dr][dc] = '0';
                }
            }
        }
    }
}
