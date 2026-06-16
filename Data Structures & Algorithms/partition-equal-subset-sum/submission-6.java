// brute force wiht memoisation
class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        
        memo = new Boolean[n][sum / 2 + 1];
        // System.out.println("sum even ? " + (sum % 2 == 0));
        if (sum % 2 == 0) {
            return dfs(nums, sum / 2, 0);
        }

        
        return false;
    }
    // [3, 1, 2, 4]
    public boolean dfs (int[] nums, int target, int index) {
        if (target < 0 || index == nums.length) {
            return false;
        } else if (target == 0) {
            return true;
        } else if (memo[index][target] != null) {
            return memo[index][target];
        }

        memo[index][target] = dfs(nums, target - nums[index], index + 1)
                           || dfs(nums, target, index + 1);

        return memo[index][target];
    }
}
