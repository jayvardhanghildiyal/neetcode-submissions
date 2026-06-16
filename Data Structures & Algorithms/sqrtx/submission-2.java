class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x, answer = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            long product = (long) mid * mid;
            System.out.println("l = "  +  l + " r = " + r + " mid = " + mid);

            if (product == x) {
                return mid;
            } else if (product > x) {
                r = mid - 1;
            } else if (product < x){
                l = mid + 1;
                answer = mid;
            }
        }

        return answer;
    }
}
// 1, 2, 3, 4, 5, 6, 7, 8, 9

// l = 1,  r = 2147395600, mid = 1073697800
// l = 1, r = 1073697799, mid = 536848900
// l = 1, r = 536848899, mid = 268424450
// l = 1, r = 268424449, mid = 134212225
// l = 1