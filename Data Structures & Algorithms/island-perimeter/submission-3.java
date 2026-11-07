class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    // check all four sides for invalid values
                    answer += (i - 1 < 0 || grid[i - 1][j] == 0) ? 1 : 0;
                    answer += (i + 1 >= rows || grid[i + 1][j] == 0) ? 1 : 0;
                    answer += (j - 1 < 0 || grid[i][j - 1] == 0) ? 1 : 0;
                    answer += (j + 1 >= cols || grid[i][j + 1] == 0) ? 1 : 0;
                }
            }   
        }

        return answer;
    }
}