// constant space complexity
class Solution {
    public void setZeroes(int[][] matrix) {
        // use the rows and the cols for storing indices
        int rows = matrix.length, cols = matrix[0].length;
        boolean firstRow = false;

        // store the indices of where 0s occur
        // in the first row and first column
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;

                    if (i > 0) {
                        matrix[i][0] = 0;
                    } else {
                        firstRow = true;
                    }
                }
            }
        }

        // make rows and cols zero
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // during traversal, (0, 0) can be achieved if a value in the first column is zero
        // let's say that (3, 0) is zero. if a value (i, j) 
        // we record it in the first row and column like this -> (i, 0) and (0, j)
        // so then (3, 0) is recorded as (3, 0) and (0, 0)
        // so (0, 0) doesn't necessarily mean that the first row must also be zero
        // and we must record proof of the first row being zero elsewhere
        if (matrix[0][0] == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

        // there is a possibility that the first row has a zero in it
        // taken on from our previous example, let's say we have (0, 3)
        // then, we have to record (0, 3) and (0, 0)
        // and this means that even though we havve (0, 0), nothing happens to the first column
        // when we find the first row has a zero int it, we just set firstRow to true
        // without recording (0, 0) in our matrix 
        if (firstRow) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}