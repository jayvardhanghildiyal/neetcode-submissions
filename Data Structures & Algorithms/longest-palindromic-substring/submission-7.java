class Solution {
    String str = "";
    public String longestPalindrome(String s) {
        int l;
        int r;

        for (int i = 0; i < s.length(); i++) {
            // even case
            LPS(s, i, i);

            // odd case
            LPS(s, i, i + 1);
        }

        return str;
    }


    // code is repeated, right ? make it a function
    public void LPS (String s, int l, int r) {
        while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
            if (str.length() < r - l + 1) {
                str = s.substring(l, r + 1);
            }

            l -= 1;
            r += 1;
        }
    }
}

