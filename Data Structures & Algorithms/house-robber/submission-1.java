class Solution {
    int[] arr;
    public int rob(int[] nums) {
        arr = new int[nums.length];
        Arrays.fill(arr, -1);
        return dp(nums, 0);

    }

    public int dp(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        } else if (arr[i] != -1) {
            return arr[i];
        }
        arr[i] = Math.max(dp(nums, i + 1), nums[i] + dp(nums, i + 2));
        return arr[i];
    }
}

// nums[i] + nums[i + 2], arr[i + 1]
