class Solution {
    public int missingNumber(int[] nums) {
        // // math solution
        // int sum = 0, n = nums.length;

        // for (int num : nums) {
        //     sum += num;
        // }

        // return Math.abs(sum - ((n * (n + 1)) / 2));

        // bit manipulation solution
        int n = nums.length;
        int answer = n;

        for (int i = 0; i < n; i++) {
            answer ^= nums[i] ^ i;
        }

        return answer;
        
    }
}
