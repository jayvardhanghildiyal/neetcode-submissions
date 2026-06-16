class Solution {
    public int lengthOfLastWord(String s) {
        // remove trailing spaces to make things easy for ourselves
        // String str = s.trim();
        int index = s.length() - 1;
        int count = 0;

        while (s.charAt(index) == ' ') {
            index -= 1;
        }

        
        while (index >= 0 && s.charAt(index) != ' ') {
            count += 1;
            index -= 1;
        }

        return count;
    }
}