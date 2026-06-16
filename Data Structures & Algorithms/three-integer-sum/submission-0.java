class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> arr = new ArrayList<>();

        for (int start = 0; start < nums.length - 2; start++) {

            int mid = start + 1;
            int end = nums.length - 1;

            while (mid < end) {
                if (nums[start] + nums[mid] + nums[end] == 0) {
                    ArrayList<Integer> ele = new ArrayList<>();
                    ele.add(nums[start]);
                    ele.add(nums[mid]);
                    ele.add(nums[end]);

                    if (!arr.contains(ele)) {
                        arr.add(ele);
                    }
                    
                    mid += 1;
                } else if (nums[start] + nums[mid] + nums[end] < 0) {
                    mid += 1;
                } else if (nums[start] + nums[mid] + nums[end] > 0) {
                    end -= 1;
                }
            }
        }

        return arr;
    }
}
