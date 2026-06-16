class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(nums, temp, new boolean[nums.length]);
        return list;
    }

    public void dfs (int[] nums, List<Integer> temp, boolean[] picked) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return ;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!picked[i]) {
                    temp.add(nums[i]);
                    picked[i] = true;
                    dfs(nums, temp, picked);
                    temp.remove(temp.size() - 1);
                    picked[i] = false;
                }
            }
        }
    }
}
