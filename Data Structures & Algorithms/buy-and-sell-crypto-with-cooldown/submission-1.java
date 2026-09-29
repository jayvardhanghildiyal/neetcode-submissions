// top-down
class Solution {
    // int profit = 0;
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs (0, 1, prices);
    }

    public int dfs(int index, int buying, int[] prices) {
        if (index >= prices.length) {
            return 0;
        } else if (dp[index][buying] != -1) {
            return dp[index][buying];
        }

        // so i guess cooldown represent skipping a day
        // and allows us to traverse other possibilities
        int moveon = dfs (index + 1, buying, prices);
        // if we want to buy
        if (buying == 1) {
            int buy = dfs(index + 1, 0, prices) - prices[index];
            dp[index][buying] = Math.max(buy, moveon);
        }
        // if we have already bought, we likely wanna sell
        else {
            int sell = dfs (index + 2, 1, prices) + prices[index];
            dp[index][buying] = Math.max(sell, moveon);
        }

        return dp[index][buying];
    }
}