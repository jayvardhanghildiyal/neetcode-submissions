// bit manipulation
class Solution {
    public int majorityElement(int[] nums) {
        // record all set bits and use them to reconstruct the most common number
        // because bits from that number should exist atleast n / 2 times !
        // fucking genius
        int[] bits = new int[32];
        int answer = 0;
        // record all bits that are set
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num >> i) & 1;
            }
        }

        // create set bits at the positions where the condition meets
        for (int i = 0; i < 32; i++) {
            if (bits[i] > nums.length / 2) {
                answer = answer | (1 << i);
            }
        }

        return answer;
    }
}