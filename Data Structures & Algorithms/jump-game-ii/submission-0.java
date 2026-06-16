class Solution {
    public int jump(int[] nums) {
        int n = nums.length - 1;
        int l = 0;
        int r = 0;
        int steps = 0;

        while (r < n) {
            int max = 0;
            for (int i = l; i <= r; i++) {
                max = Math.max(max, i + nums[i]);
            }
            l = r + 1;
            r = max;
            steps += 1;
        }

        return steps;
        
    }
}
