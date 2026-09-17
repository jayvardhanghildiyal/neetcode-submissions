class NumMatrix {
    int[][] matrix;
    // create the prefix sum array instead of the normal one
    // we can use the provided indices get the sum in constant time
    public NumMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        this.matrix = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
                this.matrix[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // get the upper sum
        int upperSum = 0;

        for (int i = row1; i <= row2; i++) {
            upperSum += matrix[i][col2];
        }
        // subtract with lower sum is we can
        int lowerSum = 0;
        if (col1 > 0) {
            for (int i = row1; i <= row2; i++) {
                lowerSum += matrix[i][col1 - 1];
            }
        }

        return upperSum - lowerSum;
        // int sum = 0;

        // for (int r = row1; r <= row2; r++) {
        //     for (int c = col1; c <= col2; c++) {
        //         sum += matrix[r][c];
        //     }
        // }

        // return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */