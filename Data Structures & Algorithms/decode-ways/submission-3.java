class Solution {
    int count = 0;
    public int numDecodings(String s) {
        dfs(s, 0, 1);
        if (s.length() > 1) {
            dfs(s, 0, 2);
        }
        return count;
    }
    // 1 0 1 2
    public void dfs (String s, int start, int end) {
        
        if (s.charAt(start) == '0') {
            return ;
        }
        
        String str = s.substring(start, end);
        int i = Integer.parseInt(str);

        if (i > 26) {
            return ;
        }

        if (start == s.length() || end == s.length()) {
            count += 1;
            return ;
        } else if (end > s.length()) {
            return ;
        }
        

        // take one at a time
        dfs(s, end, end + 1);

        //take two at a time
        if (end + 2 <= s.length()) {
            dfs(s, end, end + 2);
        }
    }
}
