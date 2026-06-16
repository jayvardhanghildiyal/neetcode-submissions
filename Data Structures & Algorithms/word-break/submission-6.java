// start building index knowledge from the end of the string
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        // start from behind
        for (int i = s.length() - 1; i >= 0; i--) {
            // check all words
            for (String word : wordDict) {
                int len = i + word.length();

                if (len <= s.length() && s.substring(i, len).equals(word)) {
                    dp[i] = dp[len];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
