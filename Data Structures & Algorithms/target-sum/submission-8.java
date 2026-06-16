// bottom-up (space optimized)
class Solution {
    // a lot of the time, the dp solution can be built
    // but we don't need the previous steps
    // a lot of the times, discarding the previous step is the key
    // to getting an optimized solution
    public int findTargetSumWays(int[] nums, int target) {
        // previous level
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            // new level we wanna build
            Map<Integer, Integer> nextDp = new HashMap<>();
            // take elements from the previous level to build it
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                int total = entry.getKey();
                int count = entry.getValue();

                nextDp.put(total + num, nextDp.getOrDefault(total + num, 0) + count);
                nextDp.put(total - num, nextDp.getOrDefault(total - num, 0) + count);
            }
            dp = nextDp;
        }

        return dp.getOrDefault(target, 0);
    }
}
