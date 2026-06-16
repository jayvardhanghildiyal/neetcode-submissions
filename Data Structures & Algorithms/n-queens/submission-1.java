class Solution {
    List<List<String>> answer = new ArrayList<>();
    Set<Integer> col = new HashSet<>();
    Set<Integer> posD = new HashSet<>();
    Set<Integer> negD = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        nq(0, board);
        return answer;
 
    }    

    public void nq (int r, char[][] board) {
        if (r == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] c : board) {
                temp.add(new String(c));
            }
            answer.add(temp);
            return ;
        } else {
            for (int c = 0; c < board.length; c++) {
                if (!col.contains(c) && !posD.contains(r + c) && !negD.contains(r - c)) {
                    board[r][c] = 'Q';
                    col.add(c);
                    posD.add(r + c);
                    negD.add(r - c);

                    nq(r + 1, board);

                    board[r][c] = '.';
                    col.remove(c);
                    posD.remove(r + c);
                    negD.remove(r - c);
                }  
            }
        }
    }

    // public boolean safe(int r, int c, char[][] board) {
    //     for (int i = r - 1; i >= 0; i--) {
    //         if (board[i][c] == 'Q') {
    //             return false;
    //         }
    //     }

    //     for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }

    //     for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
    //         if (board[i][j] == 'Q') {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}
