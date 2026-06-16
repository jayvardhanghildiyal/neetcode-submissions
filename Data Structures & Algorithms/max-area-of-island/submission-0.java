class Solution {
    public int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int currArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int maxArea = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    maxArea = Math.max(maxArea, currArea);
                    currArea = 0;
                }
            }
        }

        return maxArea;
    }

    public void dfs (int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || 
             c == grid[0].length || grid[r][c] == 0) {
                return ;
        }

        currArea += 1;
        // this set of coordinates have been traversed
        grid[r][c] = 0;

        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            dfs(grid, nr, nc);
        }        
    }
}
