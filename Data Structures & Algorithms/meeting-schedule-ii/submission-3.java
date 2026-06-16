/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int answer = 0, count = 0, s = 0, e = 0;
        while (s < n) {
            if (start[s] < end[e]) {
                s += 1;
                count += 1;
            } else {
                e += 1;
                count -= 1;
            }
            
            // stores the max number of simultaneous meetings
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
