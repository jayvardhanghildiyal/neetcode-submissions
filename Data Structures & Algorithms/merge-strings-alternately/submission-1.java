class Solution {
    public String mergeAlternately(String word1, String word2) {
        int start1 = 0, start2 = 0;
        StringBuilder sb = new StringBuilder();

        while (start1 < word1.length() || start2 < word2.length()) {
            if (start1 < word1.length()) {
                sb.append(word1.charAt(start1));
                start1 += 1;
            }

            if (start2 < word2.length()) {
                sb.append(word2.charAt(start2));
                start2 += 1;
            }

        }

        return sb.toString();
    }
}