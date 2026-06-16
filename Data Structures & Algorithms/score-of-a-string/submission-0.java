class Solution {
    public int scoreOfString(String s) {
        int answer = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length - 1; i++) {
            answer += Math.abs(c[i + 1] - c[i]);
        }

        return answer;
    }
}