class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;

        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                fast += 1;
            } else {
                slow += 1;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}

// store = 10
// [2, 10, 30s, 30, 30, 30]