// if two land cells are adjacent
// 2 sides (from both cells) are now out of the total perimeter count
// check top and left cell. if there is a cell below or to the right
// it will be counted later in the loop
class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    answer += 4;
                    // subtract 2 for two adjacent cells
                    answer -= (i - 1 >= 0 && grid[i - 1][j] == 1) ? 2 : 0;
                    answer -= (j - 1 >= 0 && grid[i][j - 1] == 1) ? 2 : 0;
                }
            }   
        }

        return answer;
    }
}