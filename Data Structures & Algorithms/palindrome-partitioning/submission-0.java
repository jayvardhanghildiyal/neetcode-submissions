class Solution {
    List<List<String>> answer;
    List<String> part;
    public List<List<String>> partition(String s) {
        answer = new ArrayList<>();
        part = new ArrayList<>();
        dfs(0, s, part, answer);
        return answer;
    }

    public void dfs (int i, String s, List<String> part, List<List<String>> answer) {
        if (i == s.length()) {
            answer.add(new ArrayList<>(part));
            return ;
        } else {
            for (int j = i; j < s.length(); j++) {
                if (palindrome(s, i, j)) {
                    part.add(s.substring(i, j + 1));
                    dfs(j + 1, s, part, answer);
                    part.remove(part.size() - 1);
                }
            }
        }
    }

    public boolean palindrome (String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l += 1;
                r -= 1;
            }
        }

        return true;
    }

}
