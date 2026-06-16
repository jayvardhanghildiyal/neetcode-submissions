// 2D dp (bottom up)
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[len + 1][amount + 1];

        for (int i = 0; i < len + 1; i++) {
            dp[i][0] = 1;
        }
        // answer will be built from filling the bottom of the array
        // so we should build the array from the bottom up
        // and not top down (can't fetch value that doesn't exist like in recursion)
        for (int index = len - 1; index >= 0; index--) {
            for (int a = 0; a <= amount; a++) {
                if (a - coins[index] >= 0) {
                    dp[index][a] = dp[index + 1][a] + dp[index][a - coins[index]];
                }
            }
        }

        return dp[0][amount];
    }
}

// target = 4, coins = [1, 2, 3]

// 1, 0, 0, 0, 0
// 1, 0, 1, 1, 1
// 1, 0, 0, 1, 0
// 1, 0, 0, 0, 0