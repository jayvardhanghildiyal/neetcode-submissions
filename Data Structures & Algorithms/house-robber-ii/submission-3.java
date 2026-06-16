class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] arr1 = new int[nums.length - 1];
        int[] arr2 = new int[nums.length - 1];

        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);

        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);

        return Math.max(dfs(nums1, 0, arr1), dfs(nums2, 0, arr2));
    }

    public int dfs (int[] nums, int index, int[] arr) {
        if (index >= nums.length) {
            return 0;
        } else if (arr[index] != -1) {
            return arr[index];
        }

        arr[index] = Math.max(nums[index] + dfs(nums, index + 2, arr), dfs(nums, index + 1, arr));
        return arr[index];
    }
}
