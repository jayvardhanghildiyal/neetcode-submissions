// iterative
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            // get the remainder and add
            // simulates us going up the count ladder
            columnNumber -= 1;
            int remainder = columnNumber % 26;
            sb.append((char) (remainder + 'A'));
            columnNumber /= 26;
            
        }

        return sb.reverse().toString();
    }
}