class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, target, temp, 0);
        return list;
    }

    public void dfs (int[] candidates, int target, List<Integer> temp, int i) {
        if (target == 0) {
            List<Integer> pf = new ArrayList<>(temp);
            pf.sort(null);
            if (!list.contains(pf)) {
                list.add(pf);
            }
            return ;
        } else if (target < 0 || i == candidates.length) {
            return ;
        } else {
            temp.add(candidates[i]);
            dfs(candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
            dfs(candidates, target, temp, i + 1);
        }
    }
}
