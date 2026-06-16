class Solution {
    public double myPow(double x, int n) {
        // use bit-manipulation ?
        // if the power is positive, left shift
        // if the power is negative, right shift
        int pow = Math.abs(n);
        if (n == 0) {
            return 1.0;
        }

        // just calculate the reciprocal instead of using another loop
        double answer = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                answer *= x;
            }

            x *= x;
            pow >>= 1;
        }

        return n < 0 ? (1 / answer) : answer;
    }
}