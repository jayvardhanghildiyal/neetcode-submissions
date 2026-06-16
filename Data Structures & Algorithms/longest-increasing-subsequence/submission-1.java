class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, answer = 0;
        int[] max = new int[len];

        for (int k = 0; k < len; k++) {
            max[k] = 1;
            for (int i = 0; i < k; i++) {
                if (nums[k] > nums[i]) {
                    max[k] = Math.max(max[k], max[i] + 1);
                }
            }
            answer = Math.max(answer, max[k]);
        }

        return answer;
    }
}
// [1, 3k, 6, 7, 9, 4, 10, 5, 6], answer = 1
// [1, 2, 1, 1, 1, 1, 1, 1, 1]

// [9, 1, 4, 2, 3, 3, 7k], answer = 4
// [1, 1, 2, 2, 3, 3, 4]

