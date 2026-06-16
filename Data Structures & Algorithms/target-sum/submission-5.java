// brute-force solution + memoisation
class Solution {
    // int answer;
    int[][] dp;
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // answer = 0;
        for (int num : nums) {
            total += num;
        }
        dp = new int[nums.length][2 * total + 1];
        // fill with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(nums, 0, 0, target);

        // return answer;
    }
    // we add it the indice sum with total to account for negative sums
    // this way, we kinda get an absolute negative value
    public int dfs (int[] nums, int sum, int index, int target) {
        if (index == nums.length && sum == target) {
            return 1;
            // answer += 1;
            // dp[index - 1][target] = 1;
            // return ;
        } else if (index == nums.length) {
            return 0;
        } else if (dp[index][sum + total] != -1) {
            return dp[index][sum + total];
            // answer += 1;
            // // return ;
        }

        dp[index][sum + total] = dfs(nums, sum + nums[index], index + 1, target)
               + dfs(nums, sum - nums[index], index + 1, target);
        
        return dp[index][sum + total];
    }
}
