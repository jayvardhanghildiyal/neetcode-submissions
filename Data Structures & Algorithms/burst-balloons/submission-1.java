// neetcode top down 2D
class Solution {

    int[][] dp;

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++){
            arr[i + 1] = nums[i];
        }

        // dp array for storage
        // -1 for invalid spaces
        dp = new int[n + 2][n + 2];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs (arr, 1, n);
    }

    public int dfs (int[] arr, int l, int r) {

        if (l > r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }

        dp[l][r] = 0;

        for (int i = l; i <= r; i++) {
            
            // simulating last pick for ith index ?
            int coins = arr[l - 1] * arr[i] * arr[r + 1];
            
            coins += dfs(arr, l, i - 1) + dfs(arr, i + 1, r);

            dp[l][r] = Math.max(dp[l][r], coins);
        }

        return dp[l][r];
    }
}
// [4, 2, 3, 7] -> [] = 0 , [4] = 4, [2, 3, 7]
// [2, 3, 7] -> [], [2], [3, 7]
// [3, 7] -> [], [3], [7] = 3 * 7 * 1
