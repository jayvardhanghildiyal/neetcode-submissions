// cycle detection using floyd's algorithm
// used in linked list cycle detection
// it's beautiful really
// use cycle detection in anything cycle related
class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = happi(n);

        while (slow != fast) {
            fast = happi(fast);
            fast = happi(fast);
            slow = happi(slow);
        }

        return fast == 1;
    }


    // use the same function as last time
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
