// cleaner approach
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                // no change required
                five += 1;
            } else if (bill == 10) {
                // change is equal to 5
                ten += 1;
                five -= 1;
            } else if (bill == 20 && ten >= 1) {
                // change is equal to 15
                ten -= 1;
                five -= 1;
            } else {
                // change is 15 but no 10 notes available
                five -= 3;
            }

            if (five < 0) {
                return false;
            }
        }

        return true;
    }
}