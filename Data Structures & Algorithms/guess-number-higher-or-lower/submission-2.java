/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n, answer = -1;

        while (l <= r) {
            int mid = ((r - l) / 2) + l;

            if (guess(mid) == 0) {
                answer = mid;
                break;
            } else if (guess(mid) == -1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return answer;
    }
}

// [1l, 2r]