class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        List<Integer> list = new ArrayList<Integer>();
        int size = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            size += 1;
            end = Math.max(end, map.get(s.charAt(i)));

            if (i == end) {
                list.add(size);
                size = 0;
            }
        }

        return list;
    }
}
