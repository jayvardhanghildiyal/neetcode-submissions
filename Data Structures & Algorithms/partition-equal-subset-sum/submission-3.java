class Solution {
    boolean answer;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // System.out.println("sum even ? " + (sum % 2 == 0));
        if (sum % 2 == 0) {
            backtracking(nums, sum / 2);
            return answer;
        }

        return false;
    }

    public void backtracking (int[] nums, int target) {
        if (target == 0) {
            answer = true;
            return ;
        } else if (target < 0) {
            return ;
        }

        // System.out.println("target value : " + target);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                continue;
            } else if (answer == true) {
                return ;
            }

            int temp = nums[i];
            nums[i] = -1;
            backtracking(nums, target - temp);
            nums[i] = temp;
        }
    }
}
