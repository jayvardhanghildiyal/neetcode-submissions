class Solution {
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        int rows = board.length, cols = board[0].length;
        boolean[][] invalid = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            bfs(i, 0, board, invalid);
            bfs(i, cols - 1, board, invalid);
        }

        for (int j = 0; j < cols; j++) {
            bfs(0, j, board, invalid);
            bfs(rows - 1, j, board, invalid);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (invalid[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs (int row, int col, char[][] board, boolean[][] invalid) {
        if (board[row][col] == 'X') {
            return ;
        }

        invalid[row][col] = true;
        for (int[] d : directions) {
            int r = row + d[0], c = col + d[1];
            
            if (r < 0 || r >= board.length 
            || c < 0 || c >= board[0].length || board[r][c] == 'X' || invalid[r][c] == true) {
                continue ;
            }

            dfs(r, c, board, invalid);
        }

    }

    private void bfs (int row, int col, char[][] board, boolean[][] invalid) {
        if (board[row][col] == 'X') {
            return ;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});

        while (!q.isEmpty()) {
            int[] coords = q.poll();
            int r = coords[0], c = coords[1];
            invalid[r][c] = true;

            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                
                if (nr < 0 || nr >= board.length 
                || nc < 0 || nc >= board[0].length || board[nr][nc] == 'X' || invalid[nr][nc] == true) {
                    continue ;
                }

                q.add(new int[]{nr, nc});
            }
        }
    }
}
