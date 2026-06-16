class Solution {
    int[] arr1;
    int[] arr2;
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        arr1 = new int[nums.length - 1];
        arr2 = new int[nums.length - 1];
        int[] nums1 = Arrays.copyOfRange(nums, 1, nums.length);
        int[] nums2 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);
        return Math.max(dp(nums1, 0, arr1), dp(nums2, 0, arr2));
    }

    public int dp(int[] nums, int i, int[] arr) {
        if (i >= nums.length) {
            return 0;
        } else if (arr[i] != -1) {
            return arr[i];
        }
        arr[i] = Math.max(dp(nums, i + 1, arr), nums[i] + dp(nums, i + 2, arr));
        return arr[i];
    }
}