class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, r = nums1.length - 1;

        while (p >= 0 && q >= 0) {
            nums1[r] = Integer.MIN_VALUE;
            if (nums1[p] >= nums2[q]) {
                nums1[r] = nums1[p];
                p -= 1;
            } else if (nums2[q] >= nums1[p]) {
                nums1[r] = nums2[q];
                q -= 1;
            }

            r -= 1;
        }

        // if the pointer of nums2 reaches ends first
        // then nums1 is sorted as is
        // no need to check for that
        if (q >= 0) {
            while (r >= 0) {
                nums1[r] = nums2[q];
                q -= 1;
                r -= 1; 
            }
        }
    }
}

// p , r [1, 2, 10, 20, 20, 40]
// q [1, 2]