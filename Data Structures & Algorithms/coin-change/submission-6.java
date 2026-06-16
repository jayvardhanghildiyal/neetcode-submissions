class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int ans = dfs(coins, amount);
        return ans >= 1e9 ? -1 : ans; 
    }

    public int dfs (int[] coins, int amount) {
        if (amount == 0) {
            return 0; 
        } else if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int answer = (int) 1e9; // because e is a double value
        for (int coin : coins) {
            if (amount - coin >= 0) {
                answer = Math.min(answer, 1 + dfs(coins, amount - coin));
                if (!map.containsKey(amount)) {
                    map.put(amount, (int) 1e9);
                }
                map.put(amount, Math.min(map.get(amount), answer));
            }
        }

        return answer;
    }
}
