class Solution {
    public int reverse(int x) {
        // 13 = 1101, 31 = 11111
        // 1234 = 10011010010, 4321 = 1000011100001
        // there seems to be no co-relation between the bits
        // bit manipulation not required to reverse them

        // handle reversing bigger numbers that may exceed the range 
        // int temp = x, count = 0;

        // while (temp > 0) {
        //     temp /= 10;
        //     count += 1;
        // }

        // if (count == 10 && x % 10 > 2) {
        //     return 0;
        // }

        long answer = 0;
        int sign = (x < 0) ? -1 : 1;
        x *= sign;
        // try to reverse numbers
        while (x > 0) {
            // extract digit
            int digit = x % 10;
            // reduce x
            x /= 10;
            // build number
            answer = answer * 10 + digit;

            if (answer > Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) answer * sign;
    }
}
