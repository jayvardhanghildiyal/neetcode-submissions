class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // static array that helps us maintain digit position
        int[] res = new int[num1.length() + num2.length()];
        // reversing strings to traverse easily
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int digit = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] += digit;
                // carry
                res[i + j + 1] += res[i + j] / 10;
                // single digit number that remains at the position
                res[i + j] %= 10; 
            }
        }

        StringBuilder sb = new StringBuilder();
        // start with the back
        // don't need to reverse that way
        int i = res.length - 1;
        // skip the non-zero spots
        while (i >= 0 && res[i] == 0) {
            i -= 1;
        }
        while (i >= 0) {
            sb.append(res[i]);
            i -= 1;
        }

        return sb.toString();
    }
}
