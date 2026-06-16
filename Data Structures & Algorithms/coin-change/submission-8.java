class Solution {
    // Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        // int ans = dfs(coins, amount);
        // return ans >= 1e9 ? -1 : ans;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int a = 1; a < amount + 1; a++) { // this loop goes through 1 to the amount value
            for (int i = 0; i < coins.length; i++) { // this loop goes through every single coin value 
                if (a - coins[i] >= 0) {
                    dp[a] = Math.min(dp[a], 1 + dp[a - coins[i]]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // public int dfs (int[] coins, int amount) {
    //     if (amount == 0) {
    //         return 0; 
    //     } else if (map.containsKey(amount)) {
    //         return map.get(amount);
    //     }

    //     int answer = (int) 1e9; // because e is a double value
    //     for (int coin : coins) {
    //         if (amount - coin >= 0) {
    //             answer = Math.min(answer, 1 + dfs(coins, amount - coin));
    //             if (!map.containsKey(amount)) {
    //                 map.put(amount, (int) 1e9);
    //             }
    //             map.put(amount, Math.min(map.get(amount), answer));
    //         }
    //     }

    //     return answer;
    // }
}
