class Solution {
    boolean[][] ventured;
    public boolean exist(char[][] board, String word) {
        ventured = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (robot(i, j, board, word, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean robot (int i, int j, char[][] board, String word, int k) {
        if (k == word.length()) {
            return true;
        } else if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || ventured[i][j] == true) {
            return false;
        } else if (word.charAt(k) == board[i][j]) {
            ventured[i][j] = true;
            k += 1;
            boolean answer = robot(i + 1, j, board, word, k) || robot(i - 1, j, board, word, k) || robot(i, j + 1, board, word, k) || robot(i, j - 1, board, word, k);
            ventured[i][j] = false;
            return answer;
        } else {
            return false;
        }
    }
}
