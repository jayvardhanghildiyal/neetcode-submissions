class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int min1 = 0;
        int i = 0;
        while (i < cost.length) {
            min1 += cost[i];
            if (i + 1 >= cost.length || i + 2 >= cost.length) {
                break;
            } else if (cost[i + 1] < cost[i + 2]) {
                i += 1;
            } else {
                i += 2;
            }
        }

        int min2 = 0;
        i = 1;
        while (i < cost.length) {
            min2 += cost[i];
            if (i + 1 >= cost.length || i + 2 >= cost.length) {
                break;
            } else if (cost[i + 1] < cost[i + 2]) {
                i += 1;
            } else {
                i += 2;
            }
        }

        if (min1 < min2) {
            return min1;
        } else {
            return min2;
        }
    }
}
