// rotate by four cells of each row
class Solution {
    public void rotate(int[][] matrix) {
        int l = 0, r = matrix.length - 1;

        while (l < r) {
            // iterate in new layer
            for (int i = 0; i < r - l; i++) {
                // the top-most number and the bottom-most number in each layer
                // are represented by l and r respectively
                int topLeft = matrix[l][l + i];

                // bottom left -> top left
                matrix[l][l + i] = matrix[r - i][l];
                
                // bottom right -> bottom left
                matrix[r - i][l] = matrix[r][r - i];

                // top right -> bottom right
                matrix[r][r - i] = matrix[l + i][r];

                // top left -> top right
                matrix[l + i][r] = topLeft;
            }
            // move to next layer of the matrix
            l += 1;
            r -= 1;
        }
    }
}

//  1,  2,  3,  4
//  5,  6,  7,  8
//  9, 10, 11, 12
// 13, 14, 15, 16