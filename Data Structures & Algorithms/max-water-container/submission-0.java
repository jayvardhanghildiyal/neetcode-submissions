class Solution {
    public int maxArea(int[] heights) {
       int start = 0;
        int end = heights.length - 1;
        int area = 0;
        while (start < end) {
            int min = Math.min(heights[start], heights[end]);

            if (min * (end - start) > area) {
                area = min * (end - start);
            }

            if (heights[start] < heights[end]) {
                start += 1;
            } else  {
                end -= 1;
            }
        }

        return area;
    }
}
