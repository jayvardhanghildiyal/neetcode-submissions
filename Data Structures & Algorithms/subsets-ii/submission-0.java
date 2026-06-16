class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        answer = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(curr, 0, nums);
        return answer;
    }

    public void dfs(List<Integer> curr, int i, int[] nums) {
        if (answer.contains(curr)) {
            return ;
        }
        else if (i == nums.length) { 
            answer.add(new ArrayList<>(curr));
            return ;
        } else {
            curr.add(nums[i]);
            dfs(curr, i + 1, nums);

            curr.remove(curr.size() - 1);
            dfs(curr, i + 1, nums);
        }
    }
}
