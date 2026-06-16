class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        int len = nums.length, LIS = 1;
        dp.add(nums[0]);

        for (int i = 0; i < len; i++) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
                LIS += 1;
                continue;
            }

            int index = Collections.binarySearch(dp, nums[i]);
            if (index < 0) {
                index = index * -1 - 1;
            }
            dp.set(index, nums[i]);
        }

        return LIS;
    }
}

// dp solution analysis, LIS = 3, i = 6
// [9, 1, 4, 2, 3, 3, 7]
// <1, 2, 3, 4>