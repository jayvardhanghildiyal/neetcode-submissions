public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // extract the next carry bit and push it forward
            // now we have all carry bits set in place where they should be
            int carry = (a & b) << 1;
            // XOR conveniently gives the result of number addition (without the carries)
            a ^= b;
            // b carries all the carry information
            b = carry;
        }
        
        return a;
    }
}