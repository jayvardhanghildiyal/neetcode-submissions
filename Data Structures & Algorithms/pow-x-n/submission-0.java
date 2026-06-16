class Solution {
    public double myPow(double x, int n) {
        // use bit-manipulation ?
        // if the power is positive, left shift
        // if the power is negative, right shift

        if (n == 0) {
            return 1.0;
        }

        double answer = 1;
        if (n < 0) {
            while (n < 0) {
                answer /= x;
                n += 1;
            }
        } else {
            while (n > 0) {
                answer *= x;
                n -= 1;
            }
        }

        return answer;
    }
}
