class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }

    // int[] arr;
    // public int minCostClimbingStairs(int[] cost) {
    //     arr = new int[cost.length];
    //     Arrays.fill(arr, -64);
    //     return Math.min(memo(cost, 0), memo(cost, 1));
    // }

    // public int dfs (int[] cost, int i) {
    //     if (i >= cost.length) {
    //         return 0;
    //     }

    //     return cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
        
    // }

    // public int memo (int[] cost, int i) {
    //     if (i >= cost.length) {
    //         return 0;
    //     } else if (arr[i] != -64) {
    //         return arr[i];
    //     }

    //     arr[i] = cost[i] + Math.min(memo(cost, i + 1), memo(cost, i + 2));
    //     return arr[i];
    // }
    

}
