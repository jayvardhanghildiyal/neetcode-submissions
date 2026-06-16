class Solution {
    public int inf = 2147483647;
    public int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, 0, new boolean[row][col]);
                }
            }
        }
    }

    public void dfs (int row, int col, int[][] grid, int steps, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length 
            || col >= grid[0].length || grid[row][col] == -1) {
            return ;
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
