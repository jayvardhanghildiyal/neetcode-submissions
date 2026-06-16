class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, curr);
        return answer;
    }

    public void dfs (int i, int[] nums, int target, List<Integer> curr) {
        if (target == 0 && !answer.contains(curr)) {
            answer.add(new ArrayList<>(curr));
        } else if (target < 0 || i >= nums.length) {
            return ;
        } else {
            curr.add(nums[i]);
            dfs(i + 1, nums, target - nums[i], curr);

            curr.remove(curr.size() - 1);
            dfs(i + 1, nums, target, curr);
        }
    }
}
