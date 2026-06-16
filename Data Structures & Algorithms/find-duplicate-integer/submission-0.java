class Solution {
    public int findDuplicate(int[] nums) {
        // big up my man floyd 

        int slow = 0, fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                break;
            }
        }

        int usain = 0;

        // 2 (p + c - x) = p + 2c - x
        while (true) {
            slow = nums[slow];
            usain = nums[usain];

            if (slow == usain) {
                return usain;
            }
        }
    }
}
