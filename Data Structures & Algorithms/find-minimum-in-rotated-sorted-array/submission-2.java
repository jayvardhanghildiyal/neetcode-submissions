class Solution {
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (nums[first] < nums[last]) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        while (mid > 0) {
            if (nums[mid - 1] < nums[mid]) {
                mid -= 1;
            } else {
                break;
            }    
        }

        return nums[mid];
    }
}
