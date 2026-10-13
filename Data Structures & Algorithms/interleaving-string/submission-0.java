// 2D top-down
class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        int len_s1 = s1.length();
        int len_s2 = s2.length();

        int size = len_s1 > len_s2 ? len_s1 : len_s2;
        dp = new Boolean[len_s1 + 1][len_s2 + 1];
        // the zeroes set the starting positions
        // for the indices of the strings
        return dfs (0, 0, 0, s1, s2, s3);
    }

    public boolean dfs (int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            // because here we wanna make sure that
            // both the strings were completely used
            return (i == s1.length() && j == s2.length());
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean answer = false;
        // check the s1 string for a match
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            // test the rest of the string
            answer = dfs(i + 1, j, k + 1, s1, s2, s3);
        }

        // check the s2 string for a match
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            // test the rest of the string
            answer = dfs(i, j + 1, k + 1, s1, s2, s3);
        }

        // if none of the characters match anymore
        // go back
        dp[i][j] = answer;
        return dp[i][j];   
    }
}