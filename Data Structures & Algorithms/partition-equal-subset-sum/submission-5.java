class Solution {
    boolean answer = false;
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        backtracking(nums, sum / 2);
        return answer;
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
            } else if (answer == true || target - nums[i] < 0) {
                return ;
            }

            int temp = nums[i];
            nums[i] = -1;
            backtracking(nums, target - temp);
            nums[i] = temp;
        }
    }
}
