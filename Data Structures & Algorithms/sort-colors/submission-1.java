// i think the brute force solution is just counting sort
class Solution {
    public void sortColors(int[] nums) {
        // same counting sort algorithm, but with more efficient space usage
        // HashMap<Integer, Integer> map = new HashMap<>();
        int[] map = new int[3];
        int min = nums[0], max = nums[0];

        // record min value, max value and frequency
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            // map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map[nums[i]] += 1;
        }

        int index = 0;
        for (int num = min; num <= max; num++) {
            // while (map.getOrDefault(num, 0) > 0) {
            while (map[num] > 0) {
                nums[index] = num;
                index += 1;
                // map.put(num, map.get(num) - 1);
                map[num] -= 1;
            }
        }
    }
}