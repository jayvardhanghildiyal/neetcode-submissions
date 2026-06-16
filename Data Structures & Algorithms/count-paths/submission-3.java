// bottom-up approach (space optimized)
class Solution {
    public int uniquePaths(int m, int n) {
        // i think the thought process here is that we only need two rows to make caculations
        // so we can save a lot of space by just keeping the two rows that we need
        int[] row = new int[n];
        Arrays.fill(row, 1);

        // ___ :    [1, 1, 1, 1, 1, 1]
        // row :    [1, 2, 3, 4, 5, 6]
        // newRow : [1, 3, 6, 10, 15, 21]
        for (int i = 1; i < m; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);

            for (int j = 1; j < n; j++) {
                newRow[j] = newRow[j - 1] + row[j];
            }
            row = newRow;
        }

        return row[n - 1];
    }
}
