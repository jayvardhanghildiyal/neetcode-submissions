class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[left];
        int rightMax = height[right];
        int maxArea = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left += 1;
                leftMax = Math.max(height[left], leftMax);
                maxArea += leftMax - height[left];
            } else {
                right -= 1;
                rightMax = Math.max(height[right], rightMax);
                maxArea += rightMax - height[right];
            }
        }

        return maxArea;
    }
}
