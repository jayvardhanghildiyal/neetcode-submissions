class Solution {
    public boolean isPalindrome(String s) {
       // create a string that has all the alphabets in it
        String string = "qwertyuiopasdfghjklzxcvbnm";

        ArrayList<String> arr = new ArrayList<>();

        // create and fill an array with small letter elements
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                arr.add(String.valueOf(s.charAt(i)).toLowerCase());
            }
        }

        // here we start checking if the palindrome is realge
        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            if (Objects.equals(arr.get(start), arr.get(end))) {
                start += 1;
                end -= 1;
            } else {
                return false;
            }
        }

        return true;
    }
}
