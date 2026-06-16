class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, 0);
        return list;
    }

    public void dfs (int[] nums, List<Integer> temp, int i) {
        if (i == nums.length) {
            List<Integer> pf = new ArrayList<>(temp);
            if (!list.contains(pf)) {
                list.add(pf);
            }
            return ;
        } else {
            temp.add(nums[i]);
            dfs(nums, temp, i + 1);
            temp.remove(temp.size() - 1);
            dfs(nums, temp, i + 1);
        }
    }
}
