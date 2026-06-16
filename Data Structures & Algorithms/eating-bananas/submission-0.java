class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;

        for (int ele : piles) {
            if (ele > max) {
                max = ele;
            }
        }

        System.out.println(max);
        
        int first = 1;
        int last = max;
        int answer = max;

        while (first <= last) {
            int k = (first + last) / 2;

            int hours = 0;

            for (int ele : piles) {
                hours += Math.ceil((double) ele / k);
            }

            if (hours <= h) {
                answer = Math.min(answer, k);
                last = k - 1;
            } else {
                first = k + 1;
            }
        } 

        return answer;
    }
}
