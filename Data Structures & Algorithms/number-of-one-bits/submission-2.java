class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        
        // // this shifts the bits inside of the binary number n 
        // for (int i = 0; i < 31; i++) {
        //     if (((n >> i) & 1) == 1) {
        //         sum += 1;
        //     }
        // }

        // // here, instead of shifting the bits in n, we shift the bits in one instead
        // for (int i = 0; i < 31; i++) {
        //     if (((1 << i) & n) != 0) {
        //         sum += 1;
        //     }
        // }

        // i think this is the same as the first solution, but we leverage the n value getting smaller
        while (n != 0) {
            sum += (n & 1) == 1 ? 1 : 0;
            n >>= 1;
        }

        return sum;
    }
}
