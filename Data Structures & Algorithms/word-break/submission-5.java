// top-down dp (hashset)
class Solution {
    Set<String> wordSet;
    Boolean[] dp;
    int maxLen;

    public boolean wordBreak(String s, List<String> wordDict) {
        // contains all words
        wordSet = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];

        maxLen = 0;

        for (String str : wordDict) {
            maxLen = Math.max(maxLen, str.length());
        }

        return dfs(s, 0);
    }

    public boolean dfs (String s, int index) {
        if (index == s.length()) {
            return true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        for (int j = index; j < Math.min(index + maxLen, s.length()); j++) {
            if (wordSet.contains(s.substring(index, j + 1))) {
                if (dfs(s, j + 1)) {
                    dp[index] = true;
                    return true;
                }
            }
        }

        dp[index] = false;
        return false;
    }
}
