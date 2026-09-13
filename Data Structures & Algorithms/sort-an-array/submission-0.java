// merge sort
class Solution {
    public int[] sortArray(int[] nums) {
        merge_sort (nums, 0, nums.length - 1);

        return nums;
    }

    public void merge_sort (int[] arr, int start, int end) {
        if (start == end) {
            return ;
        }

        int mid = (start + end) / 2;

        // these calls serve the purpose of allocating the correct indices
        merge_sort (arr, start, mid);
        merge_sort (arr, mid + 1, end);

        // indices to combine the left and right arrays
        int l = start, r = mid + 1, index = 0;
        int[] new_arr = new int[end + 1];

        // add new elements into the array
        while (l <= mid && r <= end) {
            if (arr[l] < arr[r]) {
                new_arr[index] = arr[l];
                l += 1;
            } else {
                new_arr[index] = arr[r];
                r += 1;
            }

            index += 1;
        }

        // add any elements that may be remaining
        while (l <= mid) {
            new_arr[index] = arr[l];
            l += 1;
            index += 1;
        }

        while (r <= end) {
            new_arr[index] = arr[r];
            r += 1;
            index += 1;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = new_arr[i - start];
        }
    }
}

// [1, 1, 1, 1, 2, 3, 9, 10]
// [1, 1, 9, 10] and [1, 1, 2, 3]
// [9, 10] and [1, 1] || [1, 2] and [1, 3]
// 10, 9 and 1, 1 and 1, 2 and 3, 1