// top down 2D
class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {

        // this max stores maximum distance for all starting points
        int rows = matrix.length, cols = matrix[0].length, max = 1;
        dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                max = Math.max(max, dfs (i, j, matrix));
            }
        }

        return max;
    }

    public int dfs (int i, int j, int[][] matrix) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int rows = matrix.length, cols = matrix[0].length;
        // max stores maximum distance for this starting point only
        int best = 1;

        for (int[] d : directions) {
            // create new coordinates based on direction
            int x = i + d[0], y = j + d[1];

            // check if coordinates are valid
            if (x >= rows || y >= cols || x < 0 || y < 0 || matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            // continue traversal if valid
            // one position can reutrn multiple distances
            // record the max
            best = Math.max(best, 1 + dfs (x, y, matrix));
        }
        
        dp[i][j] = best;
        return best;
    }
}

// [7, 6, 5]
// [2, 7, 4]
// [1, 2, 3]