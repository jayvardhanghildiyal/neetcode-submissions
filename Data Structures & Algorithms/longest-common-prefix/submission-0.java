class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 201;
        StringBuilder sb = new StringBuilder();

        // find string with biggest length
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }

        for (int i = 0; i < minLen; i++) {
            // character that we are trying to match 
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                // try to check if all strings have this character in them
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}