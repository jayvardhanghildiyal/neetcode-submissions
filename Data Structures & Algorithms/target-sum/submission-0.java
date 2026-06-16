class Solution {
    int answer;
    public int findTargetSumWays(int[] nums, int target) {
        answer = 0;

        dfs(nums, 0, 0, target);

        return answer;
    }

    public void dfs (int[] nums, int sum, int index, int target) {
        if (index == nums.length && sum == target) {
            answer += 1;
            return ;
        } else if (index == nums.length) {
            return ;
        }

        dfs(nums, sum + nums[index], index + 1, target);
        dfs(nums, sum - nums[index], index + 1, target);
    }
}
