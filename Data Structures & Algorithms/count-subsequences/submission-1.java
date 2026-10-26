class Solution {
    // int count = 0;
    int[][] dp;

    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs (0, 0, s, t);
    }

    public int dfs (int i, int j, String s, String t) {
        if (j == t.length()) {
            return 1;
        } else if (i == s.length()) {
            return 0;
        } else if (dp[i][j] != -1) {
            return dp[i][j];
        }
        
        int answer = 0;
        // i and j match
        if (s.charAt(i) == t.charAt(j)) {
            answer += dfs (i + 1, j + 1, s, t);
        }
        
        // i and j don't match
        answer += dfs (i + 1, j, s, t);

        dp[i][j] = answer;

        return answer;
    }
}

// c a a a t
// c a t

// [ 3, -1, -1]
// [ 0,  3, -1]
// [ 0,  2,  1]
// [ 0,  1,  1]
// [ 0,  0,  1]
