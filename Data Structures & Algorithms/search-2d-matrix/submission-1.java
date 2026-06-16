class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int[] arr = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }

        // for (int ele: arr) {
        //     System.out.println(ele + " ");
        // }

        //System.out.println("end of the array");
        
        int index = bs(arr, target);
        //System.out.println(index);

        if (arr[index] == target) {
            return true;
        } else if (arr[index] > target) {
            index -= 1;
        }

        if (index < 0) {
            return false;
        }

        int Index = bs(matrix[index], target);

        if (matrix[index][Index] == target) {
            return true;
        } else {
            return false;
        }
    }

    public int bs (int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            }
        }

        return mid;
    }
}
