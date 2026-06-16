class Solution {
    public boolean isHappy(int n) {
        // store the sums achieved to detect cycle
        // otherwise go crazy
        Set<Integer> set = new HashSet<>();

        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            
            n = happi(n);
        }

        return true;
    }

    public int happi (int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }
}
// 19 = 1 + 81 = 82
// 82 = 64 + 4 = 68
// 68 = 36 + 64 = 100
// 100 = 1 + 0 + 0 = 1
