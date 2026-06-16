// brute force + 2D DP
class Solution {
    int[][] dp;
    int padding;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        // create padding 
        // padding = amount;

        dp = new int[coins.length][amount + 1];
        
        return dfs(coins, amount, 0);
    }

    public int dfs (int[] coins, int amount, int index) {
        if (index == coins.length || amount < 0) {
            return 0;
        } else if (amount == 0) {
            return 1;
        } else if (dp[index][amount] != 0) {
            return dp[index][amount];
        }

        dp[index][amount] = dfs(coins, amount - coins[index], index)
                                    + dfs(coins, amount, index + 1);
        return dp[index][amount];
    }
}
