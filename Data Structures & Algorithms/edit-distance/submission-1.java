class Solution {

    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, word1, word2);
    }

    public int dfs (int i, int j, String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        // base case
        if (i == len1 && j == len2) {
            return 0;
        } else if (j == len2 && i < len1) {
            // removals are required from word1
            return len1 - i;
        } else if (i == len1 && j < len2) {
            // insertions are required from word2
            return len2 - j;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, word1, word2);
        } else {
            // don't fix possibilities
            // we can always try everything at once
            // here we check for "delete" and "insert"
            // go forward both indices one by one
            int res = Math.min(dfs(i + 1, j, word1, word2), dfs(i, j + 1, word1, word2));

            res = Math.min(res, dfs(i + 1, j + 1, word1, word2));
            dp[i][j] = res + 1;
        }

        return dp[i][j];
    }
}
