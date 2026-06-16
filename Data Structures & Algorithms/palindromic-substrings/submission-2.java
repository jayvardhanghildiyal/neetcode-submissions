class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            // even case
            LPS(s, i, i + 1);

            // odd case
            LPS(s, i, i);
        }


        return count;
    }

    public void LPS (String s, int l, int r) {
        while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
            count += 1;
            l -= 1;
            r += 1;
        }
    }
}
