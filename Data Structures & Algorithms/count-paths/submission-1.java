// brute-force + 2D DP
class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(m - 1, n - 1);
    }

    public int dfs (int down, int right) {
        if (down < 0 || right < 0) {
            return 0;
        } else if (down == 0 && right == 0) {
            return 1;
        } else if (dp[down][right] != -1) {
            return dp[down][right];
        }

        dp[down][right] = dfs(down - 1, right) + dfs(down, right - 1);
        return dp[down][right];
    }
}
