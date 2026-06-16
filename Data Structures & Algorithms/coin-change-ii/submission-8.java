// 2D dp (bottom up - optimal)
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        // int[][] dp = new int[len + 1][amount + 1];
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // answer will be built from filling the bottom of the array
        // so we should build the array from the bottom up
        // and not top down (can't fetch value that doesn't exist like in recursion)
        for (int index = len - 1; index >= 0; index--) {
            // int[] nRow = new int[amount + 1];
            // nRow[0] = 1;

            for (int a = 1; a <= amount; a++) {
                if (a - coins[index] >= 0) {
                    dp[a] = dp[a] + dp[a - coins[index]];
                }
            }

            // pRow = nRow;
        }

        return dp[amount];
    }
}

// target = 4, coins = [1, 2, 3]

// 1, 1, 2, 0, 0
// 1, 0, 1, 1, 1
// 1, 0, 0, 1, 0
// 1, 0, 0, 0, 0


