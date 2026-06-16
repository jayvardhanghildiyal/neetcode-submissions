// bottom-up approach (optimal)
class Solution {
    public int uniquePaths(int m, int n) {
        // we can make do with just one row
        // always adding the element behind virtually gives the same effect
        int[] row = new int[n];
        Arrays.fill(row, 1);

        // first :    [1, 1, 1, 1, 1, 1]
        // second :   [1, 2, 3, 4, 5, 6]
        // third :    [1, 3, 6, 10, 15, 21]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                row[j] += row[j - 1];
            }
        }

        return row[n - 1];
    }
}