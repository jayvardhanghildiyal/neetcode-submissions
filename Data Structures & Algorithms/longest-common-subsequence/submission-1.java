// 2D dp
class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs (text1, text2, 0, 0);
    }

    public int dfs (String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        } else if (text1.charAt(i) == text2.charAt(j)) {
            // if both of the letters are the same
            // increment together       
            dp[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        } else {
            // otherwise, we might have to branch off
            // and increment separately
            dp[i][j] = Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }

        return dp[i][j];
    }
}
