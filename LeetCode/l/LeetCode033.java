package l;

public class LeetCode033 {

    /**

     33. Search in Rotated Sorted Array

     You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
       给定了一个升序的数组，一个目标值
     Suppose that nums is rotated 旋转 at some pivot 轴 unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     If target is found in the array return its index, otherwise, return -1.



     Example 1:

     Input: nums = [4,5,6,7,0,1,2], target = 0
     Output: 4
     Example 2:

     Input: nums = [4,5,6,7,0,1,2], target = 3
     Output: -1
     Example 3:

     Input: nums = [1], target = 0
     Output: -1


     Constraints:

     1 <= nums.length <= 5000
     -104 <= nums[i] <= 104
     All values of nums are unique.
     nums is guaranteed to be rotated at some pivot.
     -104 <= target <= 104

     */

    public static int search(int[] nums, int target) {
        if(null == nums || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0]==target?0:-1;
        return search(nums,nums.length,target);
    }

    static int search(int A[], int n, int target) {

        //find the index of the smallest value using binary search.
        int from = 0; int to = n-1;
        while(from < to){
            int mid = from+ (to-from)/2;
            if(A[mid] > A[to]){
                from=mid+1;
            }else{
                to = mid;
            }
        }

//        to  will be the rotated index
        int rotated = to, lo=0,hi=n-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int realmmid = (mid+rotated)%n;
            if(A[realmmid] == target) return realmmid;
            if(A[realmmid] > target){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println("keep happy ！");
//        System.out.println(search(new int[]{4,5,6,7,0,1,2},1));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},5));
    }

}