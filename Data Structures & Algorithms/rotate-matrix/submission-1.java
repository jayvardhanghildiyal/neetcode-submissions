// inplace traversal
class Solution {
    public void rotate(int[][] matrix) {
        // can't make a 2D array to store shit
        // but maybe i can use a 1D array ? is that cheating ?
        // have to do it inplace though
        int n = matrix.length;
        // print(matrix); 
        
        // reverse the matrix
        for (int i = 0; i < n / 2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n - i - 1];
            matrix[n - i - 1] = temp;
        }

        // print(matrix);

        // transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // print(matrix);
    }
    
    // public void print (int[][] matrix) {
    //     int n = matrix.length;
        
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             System.out.print(matrix[i][j] + " ");
    //         }
    //         System.out.print("\n");
    //     }
    // }
}
