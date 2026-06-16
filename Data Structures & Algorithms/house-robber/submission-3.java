class Solution {
    int[] arr;
    public int rob(int[] nums) {
        arr = new int[nums.length];
        Arrays.fill(arr, -64);
        return dfs(nums, 0);
    }

    public int dfs (int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        } else if (arr[i] != -64) {
            return arr[i];
        }

        arr[i] = Math.max(dfs(nums, i + 1), nums[i] + dfs(nums, i + 2));
        return arr[i];
    }
}
