class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        // check if the last elements match or not
        // because if we reach j == n (out of bounds for string t)
        // that was our condition for a successful match
        for (int i = 0; i < m + 1; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
