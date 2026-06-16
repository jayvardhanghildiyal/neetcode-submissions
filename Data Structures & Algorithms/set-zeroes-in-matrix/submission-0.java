// non-constant space solution
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        
        // capture all rows and cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        // update said rows and cols
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
