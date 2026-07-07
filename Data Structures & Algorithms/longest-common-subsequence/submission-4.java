// 2D dp optimal
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() < text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[] dp = new int[text2.length() + 1];
        
        for (int i = text1.length() - 1; i >= 0; i--) {
            int prev = 0;
            for (int j = text2.length() - 1; j >= 0; j--) {
                // the very last value of array
                int temp = dp[j];

                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = 1 + prev;
                } else {
                    // the same array contains the values of the previous itereations
                    // the new entries are added as we go
                    // therefore, dp[j] is present in the max method as it is different
                    // from the value being assigned to dp[j] now
                    dp[j] = Math.max(dp[j], dp[j + 1]);
                }

                prev = temp;
            }
        }

        return dp[0];
    }
}
