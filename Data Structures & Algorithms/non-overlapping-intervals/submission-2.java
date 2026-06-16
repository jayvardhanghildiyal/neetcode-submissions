class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 0;
        int prev = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] inte = intervals[i];
            if (prev <= inte[0]) {
                prev = inte[1];
            } else {
                count += 1;
                prev = Math.min(prev, inte[1]);
            }
        }

        return count;
    }
}
