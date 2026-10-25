class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0, len = nums.length;

        while (fast < len) {
            if (nums[slow] != 0) {
                if (slow == fast) {
                    fast += 1;
                }

                slow += 1;
            } else if (nums[fast] == 0) {
                fast += 1;
            } else {
                //swap the numbers
                int temp = nums[fast];
                nums[fast] = 0;
                nums[slow] = temp;
            }
        }
    }
}

// [1, 2, 5, 0s, 0, 0]f
// [1, 0s, 2f, 0, 0, 3, 4]

// [1, 2, 5l, 2, 0, 5r]