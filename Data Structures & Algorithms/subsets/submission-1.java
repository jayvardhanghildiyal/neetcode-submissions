class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, 0);
        return list;
    }

    public void dfs(int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            list.add(new ArrayList<>(temp));
            return ;
        } else {
            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
            dfs(nums, temp, i + 1);
        }
    }
}
