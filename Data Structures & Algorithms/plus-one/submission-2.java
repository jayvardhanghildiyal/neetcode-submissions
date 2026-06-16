class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1, index = digits.length - 1;
        // update the array by adding one
        while (index >= 0 && carry == 1) {
            digits[index] += carry;
            carry = 0;

            if (digits[index] == 10) {
                digits[index] = 0;
                carry = 1;
                index -= 1;
            }
        }

        // if carry is 1 after iteration, create new array and return it
        if (carry != 0) {
            int[] answer = new int[digits.length + 1];
            answer[0] = 1;
            // the only condition that the one reaches the greatest index
            // and requires us to make a new array
            // is the one where every number that came before it is zero
            
            // for (int i = 0; i < digits.length; i++) {
            //     answer[i + 1] = digits[i];
            // }
            
            return answer;
        } else {
            return digits;
        }
    }
}
