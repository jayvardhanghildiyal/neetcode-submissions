class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            int potential = prices[i + 1] - prices[i];
            
            if (potential > 0) {
                profit += potential;
            }
        }

        return profit;
    }
}

// buy at 1, sell at 5, total profit = 4
// buy at 1, sell at 3, buy at 3  and sell at 5 = 4