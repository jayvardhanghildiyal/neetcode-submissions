// cleaner version of the code
// consider asterisk with priority
// has the ability to affect the . operator as well
// top down memoization
class Solution {
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return dfs (0, 0, s, p);
    }

    public boolean dfs (int i, int j, String s, String p) {
        
        // make sure that p reaches it's end
        // necessary because the pattern string has crazy operators
        // some substring can be left over and the match can still go through for s 
        if (j == p.length()) {
            if (i == s.length()) {
                return true;
            }

            return false;
        }
        
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        dp[i][j] = false;
        boolean s1 = false, s2 = false;

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // match zero
            s1 = dfs (i, j + 2, s, p) ;

            // match more 
            // also check if the character before the asterisk
            // if the character is the same, go ahead
            if (i < s.length() && (p.charAt(j) == '.' || (s.charAt(i) == p.charAt(j)))) {
                s2 = dfs (i + 1, j, s, p) ;
            }

            dp[i][j] = s1 || s2;
        }
        
        // if the characters are the same with no asterisk involved
        else if (i < s.length() && (p.charAt(j) == '.' || (s.charAt(i) == p.charAt(j)))) {
            dp[i][j] = dfs (i + 1, j + 1, s, p) ;
        } 

        return dp[i][j];
    }
}

// xyz
// .*z

// n n n 
// n *
