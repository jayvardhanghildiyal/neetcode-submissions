class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) > nums.length / 3) {
                answer.add(key);
            }
        }

        return answer;
    }
}
// [5, 2, 3, 2, 2, 2, 2, 5, 5, 5]
// 5 (4), 2 (5), 3 (1)