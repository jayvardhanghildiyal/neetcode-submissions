class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, target, curr);
        return answer;
    }

    public void dfs (int i, int[] nums, int target, List<Integer> curr) {
        if (target < 0 || i == nums.length) {
            return ;
        } else if (target == 0) {
            answer.add(new ArrayList<>(curr));
        } else {
            curr.add(nums[i]);
            dfs(i, nums, target - nums[i], curr);

            curr.remove(curr.size() - 1);
            dfs(i + 1, nums, target, curr);
        }
    }
}
