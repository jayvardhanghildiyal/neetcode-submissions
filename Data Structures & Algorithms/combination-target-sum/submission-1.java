class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, 0, target);
        return list;
    }

    public void dfs (int[] nums, List<Integer> temp, int i, int target) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return ;
        } else if (target < 0 || i == nums.length) {
            return ;
        } else {
            temp.add(nums[i]);
            dfs(nums, temp, i, target - nums[i]);
            temp.remove(temp.size() - 1);
            dfs(nums, temp, i + 1, target);
        }
    }
}
