class Solution {
    public int hammingWeight(int n) {
        int sum = 0;
        
        // // this shifts the bits inside of the binary number n 
        // for (int i = 0; i < 31; i++) {
        //     if (((n >> i) & 1) == 1) {
        //         sum += 1;
        //     }
        // }

        for (int i = 0; i < 31; i++) {
            if (((1 << i) & n) != 0) {
                sum += 1;
            }
        }

        return sum;
    }
}
