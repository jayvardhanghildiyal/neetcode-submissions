class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;

        int[] answer = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = answer[i + n] = nums[i];
        }

        // for (int i = 0; i < 2 * n; i++) {
        //     answer[i] = nums[(i + n) % n];
        // }

        return answer;
    }
}