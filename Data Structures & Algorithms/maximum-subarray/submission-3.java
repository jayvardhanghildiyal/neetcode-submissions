class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curr = 0;

        for (int num : nums) {
            curr = Math.max(curr, 0);
            curr += num;
            max = Math.max(max, curr);
        }

        return max;
    }
}
