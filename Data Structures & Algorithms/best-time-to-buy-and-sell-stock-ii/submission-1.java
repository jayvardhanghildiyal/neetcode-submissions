// bottom-up
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int index = n - 1; index >= 0; index--) {
            for (int buying = 1; buying >= 0; buying--) {
                if (buying == 1) {
                    int buy = dp[index + 1][0] - prices[index];
                    int move_on = dp[index + 1][buying];
                    dp[index][buying] = Math.max(buy, move_on);
                } else {
                    int sell = dp[index][1] + prices[index];
                    int move_on = dp[index + 1][buying];
                    dp[index][buying] = Math.max(sell, move_on);
                }
            }
        }

        return dp[0][1];
    }
}