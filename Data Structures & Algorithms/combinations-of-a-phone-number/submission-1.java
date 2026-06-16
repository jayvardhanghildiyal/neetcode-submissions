class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dig = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        return backtracking(digits, 0, dig);
    }

    public List<String> backtracking (String digits, int i, String[] dig) {
        if (i == digits.length() - 1) {
            List<String> ar = new ArrayList<>();
            for (char c : dig[digits.charAt(i) - '0'].toCharArray()) {
                ar.add("" + c);
            }

            return ar;
        } else if (digits.length() == 0) {
            return new ArrayList<>();
        }
        
        String c = dig[digits.charAt(i) - '0'];
        List<String> arr = new ArrayList<>();
        for (int j = 0; j < c.length(); j++) {
            for (String s : backtracking(digits, i + 1, dig)) {
                arr.add("" + c.charAt(j) + s);
            }
        }

        return arr;
    }
}
