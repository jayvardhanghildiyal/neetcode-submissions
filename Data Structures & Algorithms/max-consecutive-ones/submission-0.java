class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;

        for (int num : nums) {
            if (num == 1) {
                count += 1;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        // just in case the last number of the array is 1
        max = Math.max(max, count);

        return max;
    }
}