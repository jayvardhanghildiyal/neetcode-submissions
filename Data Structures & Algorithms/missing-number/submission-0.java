class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;

        for (int num : nums) {
            sum += num;
        }

        return Math.abs(sum - ((n * (n + 1)) / 2));
        
    }
}
