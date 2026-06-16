class Solution {

    public int rob (int[] nums) {
        if (nums.length == 0) { return 0; }
        if (nums.length == 1) { return nums[0]; }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    // int[] memo;
    // public int rob(int[] nums) {
    //     memo = new int[nums.length];
    //     Arrays.fill(memo, -64);
    //     return dfs(nums, 0);
    // }

    // public int dfs (int[] nums, int i) {
    //     if (i >= nums.length) {
    //         return 0;
    //     } else if (memo[i] != -64) {
    //         return memo[i];
    //     }

    //     memo[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
    //     return memo[i];
    // }

}
