class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new boolean[nums.length]);
        return answer; 
    }

    public void dfs (List<Integer> perms, int[] nums, boolean[] picked) {
        if (perms.size() == nums.length) {
            answer.add(new ArrayList<>(perms));
            return ;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!picked[i]) {
                perms.add(nums[i]);
                picked[i] = true;
                dfs(perms, nums, picked);
                perms.remove(perms.size() - 1);
                picked[i] = false;
            }
        }
    }
}
