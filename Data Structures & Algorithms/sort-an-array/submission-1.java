// quick sort (uses pivot)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort (int[] nums, int low, int high) {
        if (low <= high) {
            // returned the index of the pivot element
            int pivot = partition (nums, low, high);

            // since pivot is the only element at the right place
            // sort the left and right halves in a similar manner
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public int partition (int[] nums, int low, int high) {
        int pivot = nums[high];

        // pointer for element bigger than pivot
        // is -1 at the start. sleep state !
        int big = low - 1;

        for (int small = low; small < high; small++) {
            // swap all small numbers to the front of the array
            if (nums[small] <= pivot) {
                // the big element pointer is incremented
                // tracks the position of the next biggest element
                big += 1;

                int temp = nums[big];
                nums[big] = nums[small];
                nums[small] = temp;
            }
        }

        // the element at the big pointer was swapped
        // has to be smaller than pivot
        // so we put pivot behind it
        big += 1;
        int temp = nums[big];
        nums[big] = nums[high];
        nums[high] = temp;
        // here, high is the pointer that stores the pivot element
        // at the very end !

        // return the index of the pivot element
        return big;
    }
}

// i = 2, j = 3
// [2,1,3,10,5]

// [5,10,2,1,3]
// [10,9,1,1,1,2,3,1]