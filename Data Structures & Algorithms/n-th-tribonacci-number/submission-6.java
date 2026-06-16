// bottom-up (space optimized)
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 3) {
            return 1;
        }
        
        int dp1 = 0, dp2 = 1, dp3 = 1, dpn = 0;

        for (int i = 3; i <= n; i++) {
            dpn = dp1 + dp2 + dp3;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dpn;
        }

        return dpn;
    }
}