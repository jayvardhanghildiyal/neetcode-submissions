// imporved solution
class Solution {
    public int removeElement(int[] nums, int val) {
        // since the rest of the elements don't matter
        // we can just add non-val values in order ig

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[answer] = nums[i];
                answer += 1;
            }
        }

        return answer;
    }
}