// breadth first search
class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int islandPerimeter(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {

                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = -1;

                    while (!q.isEmpty()) {
                        // take one land cell out
                        int[] coords = q.poll();
                        int x = coords[0], y = coords[1];

                        for (int[] d : directions) {
                            int nx = x + d[0], ny = y + d[1];

                            // invalid spaces count for perimeter
                            if (nx < 0 || ny < 0 || nx == rows || ny == cols || grid[nx][ny] == 0) {
                                answer += 1;
                            } else if (grid[nx][ny] != -1) {
                                // if cell hasn't been encountered yet
                                // add it
                                q.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }

                    return answer;
                }
            }
        }

        // doesn't matter what we return here
        // the problem states that there is exactly one island
        // no need to worry about the possibility of zero land cells
        return 6;
    }
}