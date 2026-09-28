class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return "" + ((char) (columnNumber + 64));
        }
        
        StringBuilder sb = new StringBuilder();
        // mod for units place
        int prefix = columnNumber % 26;
        // divide for what's left
        int suffix = columnNumber / 26;

        if (prefix != 0) {
            sb.append(convertToTitle(suffix));    
        }

        if (suffix != 0) {
            sb.append((char) (prefix + 64));
        }

        return sb.toString();
    }
}