class Solution {
    public String longestPalindrome(String s) {
        String str = "";
        int l;
        int r;

        for (int i = 0; i < s.length(); i++) {
            // even case
            l = i;
            r = i + 1;

            while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
                if (str.length() < r - l + 1) {
                    str = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }

            // odd case
            l = i;
            r = i;

            while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
                if (str.length() < r - l + 1) {
                    str = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }
        }

        return str;
    }
}
