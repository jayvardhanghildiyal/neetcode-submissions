class Solution {
    public int removeElement(int[] nums, int val) {
        // probably make like two pointers ?
        // front and back
        int first = 0, last = nums.length - 1, len = nums.length - 1;

        while (first < last) {
            while (first < last && nums[first] != val) {
                first += 1;
            }

            while (last > first && nums[last] == val) {
                last -= 1;
            }

            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
        }
        
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                k += 1;
            }
        }
        
        return k;
    }
}

// [0, 1, 4, 0, 3, 2, 2, 2]