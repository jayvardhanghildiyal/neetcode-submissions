class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                count += ((i >> j) & 1) == 1 ? 1 : 0;
            }
            answer[i] = count;
        }

        return answer;
    }
}
