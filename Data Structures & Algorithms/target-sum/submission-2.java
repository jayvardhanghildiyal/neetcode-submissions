// brute-force solution
class Solution {
    // int answer;
    public int findTargetSumWays(int[] nums, int target) {
        // answer = 0;

        return dfs(nums, 0, 0, target);

        // return answer;
    }

    public int dfs (int[] nums, int sum, int index, int target) {
        if (index == nums.length && sum == target) {
            return 1;
        } else if (index == nums.length) {
            return 0;
        }

        return dfs(nums, sum + nums[index], index + 1, target) 
             + dfs(nums, sum - nums[index], index + 1, target);
    }
}
