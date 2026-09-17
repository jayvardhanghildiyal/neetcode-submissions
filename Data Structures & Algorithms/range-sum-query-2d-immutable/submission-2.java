class NumMatrix {
    int[][] prefix;
    // create the prefix sum array instead of the normal one
    // we can use the provided indices get the sum in constant time
    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        prefix = new int[row][col];

        // row prefix computation
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
                prefix[i][j] = sum;
            }
        }

        // row prefix sum
        // [3, 3, 4]
        // [5, 11, 14]
        // [1, 3, 3]

        // row into col prefix sum
        // [3, 3, 4]
        // [8, 14, 18]
        // [9, 17, 21]
        
        // row to col prefix computation
        for (int j = 0; j < col; j++) {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += prefix[i][j];
                prefix[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // get the bottom-right sum
        int bottomRight = prefix[row2][col2];

        // get the bottom-left sum (if any)
        int bottomLeft = 0;
        if (col1 > 0) {
            bottomLeft = prefix[row2][col1 - 1];
        }

        // get the top-right sum (if any)
        int topRight = 0;
        if (row1 > 0) {
            topRight = prefix[row1 - 1][col2];
        }

        // get the top-left sum (if any)
        int topLeft = 0;
        if (row1 > 0 && col1 > 0) {
            topLeft = prefix[row1 - 1][col1 - 1];
        } 
        
        return bottomRight - (bottomLeft + topRight) + topLeft;
        // // get the upper sum
        // int upperSum = 0;

        // for (int i = row1; i <= row2; i++) {
        //     upperSum += matrix[i][col2];
        // }
        // // subtract with lower sum is we can
        // int lowerSum = 0;
        // if (col1 > 0) {
        //     for (int i = row1; i <= row2; i++) {
        //         lowerSum += matrix[i][col1 - 1];
        //     }
        // }

        // return upperSum - lowerSum;
    }
}

// [3, 0, 1]
// [5, 6, 3]
// [1, 2, 0]

// row prefix sum
// [3, 3, 4]
// [5, 11, 14]
// [1, 3, 3]

// col prefix sum
// [3, 0, 1]
// [8, 6, 4]
// [9, 8, 4]

// row into col prefix sum
// [3, 3, 4]
// [8, 14, 18]
// [9, 17, 21]

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */