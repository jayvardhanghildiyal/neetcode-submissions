class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<Character>();

        while (r < s.length()) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                max = Math.max(max, r - l + 1);
                r += 1;
            } else {
                set.remove(s.charAt(l));
                l += 1;
            }
        }

        return max;
    }
}
