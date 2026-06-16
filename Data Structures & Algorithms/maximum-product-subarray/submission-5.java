class Solution {
    public int maxProduct(int[] nums) {
        int answer = nums[0];
        int max = 1, min = 1;

        for (int num : nums) {
            int temp = max * num;
            max = Math.max(Math.max(num * max, num * min), num);
            min = Math.min(Math.min(temp, num * min), num);
            answer = Math.max(answer, max);
        }

        return answer;
    }
}
