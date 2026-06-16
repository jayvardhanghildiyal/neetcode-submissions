class Solution {
    public int scoreOfString(String s) {
        int answer = 0;
        // char[] c = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            answer += Math.abs(s.charAt(i + 1) - s.charAt(i));
        }

        return answer;
    }
}