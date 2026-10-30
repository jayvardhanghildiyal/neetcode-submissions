class Solution {
    // int max = 0;
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public int maxCoins(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        dfs (list);

        return dp.get(list);
    }

    public int dfs (List<Integer> list) {

        if (list.size() == 0) {
            return 0;
        } else if (dp.containsKey(list)) {
            return dp.get(list);
        }

        int max = -1;

        for (int i = 0; i < list.size(); i++) {

            // add index to set
            int temp = list.get(i);

            int p = (i - 1) < 0 ? 1 : list.get(i - 1);
            int c = list.get(i);
            int n = (i + 1) > list.size() - 1 ? 1 : list.get(i + 1);

            // remove the current number
            list.remove(i);

            max = Math.max(max, p * c * n + dfs (list));

            list.add(i, temp);
        }

        dp.put(list, max);

        return max;
    }
}


// [0, 0, 0, 0]
// [0, 0, 0, 0]
// [0, 0, 0, 0]
// [8, 0, 0, 0]

// size = 4, index = 0
// [2, 3, 7]

