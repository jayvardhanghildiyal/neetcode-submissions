class Solution {
    public boolean validPalindrome(String s) {
        
        int left = 0, right = s.length() - 1, skip = 1;
        boolean leftShift = true;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left += 1;
                right -= 1;
            } else if (skip == 1) {
                left += 1;
                skip -= 1;
            } else {
                leftShift = false;
                break;
            }
        }

        left = 0;
        right = s.length() - 1;
        skip = 1;
        boolean rightShift = true;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left += 1;
                right -= 1;
            } else if (skip == 1) {
                right -= 1;
                skip -= 1;
            } else {
                rightShift = false;
                break;
            }
        }
        
        return leftShift || rightShift;
        // int[] left = new int[26];
        // int[] right = new int[26];
        
        // int mid = s.length() / 2;

        // for (int i = 0; i < mid; i++) {
        //     left[s.charAt(i) - 'a'] += 1;
        //     right[s.charAt(s.length() - i) - 'a'] += 1;
        // }


    }
}

// [1a, 2b, 0c, 0d]
// [1a, 0b, 1c, 1d]