// top down
class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return profit (0, 1, prices);
    }

    public int profit (int index, int buying, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buying] != -1) {
            return dp[index][buying];
        }

        int move_on = profit (index + 1, buying, prices);
        if (buying == 1) {
            int buy = profit (index + 1, 0, prices) - prices[index];
            dp[index][buying] = Math.max(buy, move_on);
        } else {
            int sell = profit (index, 1, prices) + prices[index];
            dp[index][buying] = Math.max(sell, move_on);
        }

        return dp[index][buying];
    }
}