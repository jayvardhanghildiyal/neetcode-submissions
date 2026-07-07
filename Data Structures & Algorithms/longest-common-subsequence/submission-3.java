// 2D dp with space optimized
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // make sure the smaller string is text1

        // instead of using a 2D array (with a ton of arrays in it), 
        // solve it using two arrays only
        // based off of the table and how it's traversed, 2 arrays is all we need

        // the array length is taken from the longer string
        // 
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + prev[j + 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j + 1]);
                }
            }

            // this is basically why we don't need to use i at all
            // this switches the rows and simulates upward traversal in the 2D dp array
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[0];
    }
}
