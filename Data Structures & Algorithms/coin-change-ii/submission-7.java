// 2D dp (bottom up - space optimized)
class Solution {
    public int change(int amount, int[] coins) {
        int len = coins.length;
        Arrays.sort(coins);
        // int[][] dp = new int[len + 1][amount + 1];
        int[] pRow = new int[amount + 1];
        pRow[0] = 1;

        
        // answer will be built from filling the bottom of the array
        // so we should build the array from the bottom up
        // and not top down (can't fetch value that doesn't exist like in recursion)
        for (int index = len - 1; index >= 0; index--) {
            int[] nRow = new int[amount + 1];
            nRow[0] = 1;

            for (int a = 0; a <= amount; a++) {
                if (a - coins[index] >= 0) {
                    nRow[a] = pRow[a] + nRow[a - coins[index]];
                }
            }

            pRow = nRow;
        }

        return pRow[amount];
    }
}

// target = 4, coins = [1, 2, 3]

// 1, 1, 2, 0, 0
// 1, 0, 1, 1, 1
// 1, 0, 0, 1, 0
// 1, 0, 0, 0, 0

