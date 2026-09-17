// three pointers
class Solution {
    public void sortColors(int[] nums) {
        // the three pointers act as boundaries
        // that determine the position of the numbers relative to each other
        int l = 0, m = 0, r = nums.length - 1;

        // if numbers are in the wrong division / boundary
        // swap them
        while (m <= r) {
            if (nums[m] == 0) {
                swap(nums, l, m);
                l += 1;
                m += 1; // [1l, 0m, 2r]
            } else if (nums[m] == 1) {
                m += 1;
            // m is not incremented
            // because there may be a new case to test after one swap of m with 2
            } else if (nums[m] == 2) {
                swap(nums, m, r);
                r -= 1;
            }
        }
    }

    public void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// [0, 0, 1l, 1, 2mr, 2]