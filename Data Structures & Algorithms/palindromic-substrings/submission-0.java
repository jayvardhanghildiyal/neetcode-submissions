class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int l;
        int r;
        for (int i = 0; i < s.length(); i++) {
            // even case
            
            l = i;
            r = i + 1;

            while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l -= 1;
                r += 1;
            }

            // odd case

            l = i;
            r = i;

            while ((l >= 0 && r < s.length()) && s.charAt(l) == s.charAt(r)) {
                count += 1;
                l -= 1;
                r += 1;
            }
        }

        return count;
    }
}

