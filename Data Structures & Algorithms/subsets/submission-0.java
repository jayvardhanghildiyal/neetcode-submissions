class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public void dfs (int[] nums, int i, List<Integer> curr) {
        if (i >= nums.length) {
            answer.add(new ArrayList<>(curr));
            return ;
        } else {
            // option of choosing the current element
            curr.add(nums[i]);
            dfs(nums, i + 1, curr);
            
            // option of not choosing the current element
            curr.remove(curr.size() - 1);
            dfs(nums, i + 1, curr);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        dfs(nums, 0, curr);
        return answer;
    }
}
