class Solution {
    String str;
    public String longestPalindrome(String s) {
        str = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // for even length pals
            dp(i, i + 1, s);   
            // for odd length pals
            dp(i - 1, i + 1, s);
        }
        return str;
    }

    public void dp (int l, int r, String s) {
        // if (l < 0 && r > s.length() - 1) {
        //     str = s;
        //     return ;
        // } else 
        if (l < 0 || r > s.length() - 1) {
            return ;
        } else if (pal(s, l, r)) {
            if (str.length() < r - l + 1) {
                str = s.substring(l, r + 1);
            }
            dp(l - 1, r + 1, s);
        } else {
            return ;
        }
    }

    public boolean pal (String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l += 1;
                r -= 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
