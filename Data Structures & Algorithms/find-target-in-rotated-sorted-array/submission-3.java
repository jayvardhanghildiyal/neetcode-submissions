class Solution {
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] >= nums[first]) {
                if (target >= nums[first] && target <= nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else {
                if (target <= nums[last] && target >= nums[mid]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }

        return -1;
    }
}
