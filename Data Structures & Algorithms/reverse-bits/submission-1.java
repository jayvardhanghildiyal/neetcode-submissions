class Solution {
    public int reverseBits(int n) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            answer += (bit << (31 - i));
        }

        return answer;
    }
}
