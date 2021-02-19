package l;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * Follow up: The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2] 
 * Output: 2.00000 
 * Explanation: 
 * merged array =
 * [1,2,3] and median is 2. Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4] 
 * Output: 2.50000 
 * Explanation: 
 * merged array
 * = [1,2,3,4] and median is (2 + 3) / 2 = 2.5. Example 3:
 * 
 * Input: nums1 = [0,0], nums2 = [0,0] 
 * Output: 0.00000 
 * 
 * Example 4:
 * Input: nums1 = [], nums2 = [1] Output: 1.00000 
 * 
 * Example 5:
 * Input: nums1 = [2], nums2 = [] Output: 2.00000
 */
public class LeetCode004 {

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        // make sure m <= n
        if (m > n)
            return findMedianSortedArrays(B, A);

        int imin = 0, imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;

            int A_left = i == 0 ? Integer.MIN_VALUE : A[i - 1];
            int A_right = i == m ? Integer.MAX_VALUE : A[i];
            int B_left = j == 0 ? Integer.MIN_VALUE : B[j - 1];
            int B_right = j == n ? Integer.MAX_VALUE : B[j];
            System.out.println("i: "+i + " j: "+j + " A_left: "+ A_left + " A_right: "+ A_right + " B_left: "+ B_left + " B_right: "+ B_right);
            if (A_left > B_right) {
                imax = i - 1;
            } else if (B_left > A_right) {
                imin = i + 1;
            } else {
                int max_left = A_left > B_left ? A_left : B_left;
                int min_right = A_right > B_right ? B_right : A_right;
                if ((m + n) % 2 == 1)
                    return max_left; // # of left_part = # of right_part + 1;
                else
                    return (max_left + min_right) / 2.0;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // 0,1,2,3,4,5,6,7,8,9
        System.out.println(findMedianSortedArrays(new int[]{1,3,5,7,9,11,13,15},new int[]{0,2,4,6,8,}));
    }
}