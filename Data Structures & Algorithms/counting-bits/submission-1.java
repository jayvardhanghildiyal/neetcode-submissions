class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        int offset = 1;
        // for (int i = 0; i <= n; i++) {
        //     int count = 0;
        //     for (int j = 0; j < 32; j++) {
        //         count += ((i >> j) & 1) == 1 ? 1 : 0;
        //     }
        //     answer[i] = count;
        // }

        for (int i = 1; i <= n; i++) {
            if (offset * 2 == i) {
                offset = i;
            }

            answer[i] = 1 + answer[i - offset];
        }

        return answer;
    }
}
