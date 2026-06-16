class Solution {
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            int min = 0;

            if (nums[first] < nums[last]) {
                min = first;
            } else {
                min = last;
            }

            if (min == first) {
                last = mid - 1;
            } else if (min == last) {
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
