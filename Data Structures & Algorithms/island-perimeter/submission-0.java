class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    answer = dfs (i, j, grid);
                }
            }
        }   

        return answer;
    }

    public int dfs (int i, int j, int[][] grid) {

        int rows = grid.length, cols = grid[0].length;
        int perimeter = 0;
        grid[i][j] = -1;

        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];

            if (x < 0 || y < 0 || x == rows || y == cols || grid[x][y] == 0) {
                perimeter += 1;
                continue ;
            } else if (grid[x][y] == -1) {
                continue ;
            }

            perimeter += dfs (x, y, grid);
        }

        return perimeter;
    }
}