// boyer-moore voting alogorithm
class Solution {
    public int majorityElement(int[] nums) {
        int answer = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                answer = num;
            }

            count += (answer == num) ? 1 : -1;
        }

        return answer;
    }
}

// 101
// [7, 0, 4, 0, 0]
// [5, 5, 1, 1, 1, 5, 5]