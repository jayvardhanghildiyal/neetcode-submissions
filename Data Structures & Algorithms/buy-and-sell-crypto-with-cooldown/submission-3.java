// 2D top-down
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                // 1 means that we're buying
                // 0 means that we're selling
                if (buy == 0) {
                    // add zero of things go out of bounds
                    int sell = (i + 2 < n) ? dp[i + 2][1] + prices[i] : dp[n][1] + prices[i];
                    int move_on = dp[i + 1][buy];
                    dp[i][buy] = Math.max(sell, move_on);
                } else {
                    int buying = dp[i + 1][0] - prices[i];
                    int move_on = dp[i + 1][buy];
                    dp[i][buy] = Math.max(buying, move_on);
                }
            }
        }

        return dp[0][1];
    }
}
