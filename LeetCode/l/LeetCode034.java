package l;

import java.util.Arrays;

public class LeetCode034 {
    /**
     * 34 Find First and Last Position of Element in Sorted Array

     Given an array of integers nums sorted in ascending order,
     find the starting and ending position of a given target value.

     If target is not found in the array, return [-1, -1].

     Follow up: Could you write an algorithm with O(log n) runtime complexity?

     Example 1:
     Input: nums = [5,7,7,8,8,10], target = 8
     Output: [3,4]

     Example 2:
     Input: nums = [5,7,7,8,8,10], target = 6
     Output: [-1,-1]

     Example 3:
     Input: nums = [], target = 0
     Output: [-1,-1]

     Constraints:
      0 <= nums.length <= 105
      -109 <= nums[i] <= 109
      nums is a non-decreasing array.
      -109 <= target <= 109

     *
     * */

    // left side right side
    public static int[] searchRange(int[] nums, int target) {
        if(null ==nums || nums.length == 0) return new int[]{-1,-1};
        int from=0,to=nums.length-1;

        // left side
        while(from <= to){
            int mid = from+(to-from)/2;
            if(nums[mid] < target){
                from=mid+1;
            }else{
                to = mid-1;
            }
        }

        if(from > nums.length-1) return new int[]{-1,-1};

        int rightf =0,rightt= nums.length-1;
        //right side
        while(rightf <= rightt){
            int mid = rightf+(rightt-rightf)/2;
            if(nums[mid] > target){
                rightt = mid-1;
            }else{
                rightf=mid+1;
            }
        }

        if(rightt > nums.length-1) return new int[]{-1,-1};

        if(nums[from] == target && nums[rightt] == target) {
            return new int[]{from,rightt};
        }else {
            return new int[]{-1,-1};
        }
    }

    public static int[] searchRange_simple(int[] nums, int target) {
        if(null ==nums || nums.length == 0) return new int[]{-1,-1};
        int from=0,to=nums.length-1,flag=-1;
        while(from <= to){
            int mid = from+(to-from)/2;
            if(nums[mid] == target){
                flag=mid;
                break;
            }
            if(nums[mid] > target){
                to = mid-1;
            }else{
                from=mid+1;
            }
        }
        if(flag == -1){
            return new int[]{-1,-1};
        }else {
            return searchRange(nums,target,flag,flag);
        }
    }

    // log(n)
    private static int[] searchRange(int[] nums, int target, int from, int to) {
        while(from >= 0 && nums[from] == target) from--;
        while(to <= nums.length-1 && nums[to] == target) to++;
        return new int[]{++from,--to};
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");

        int[] arrsy = searchRange(new int[]{5,7,7,7,7,10},7);
        System.out.println(Arrays.toString(arrsy));

        arrsy = searchRange(new int[]{5,7,7,8,8,10},8);
        System.out.println(Arrays.toString(arrsy));

        arrsy = searchRange(new int[]{5,7,7,8,8,10},5);
        System.out.println(Arrays.toString(arrsy));

        arrsy = searchRange(new int[]{5,7,7,8,8,10},10);
        System.out.println(Arrays.toString(arrsy));

        arrsy = searchRange(new int[]{5,7,7,8,8,10},9);
        System.out.println(Arrays.toString(arrsy));

        arrsy = searchRange(new int[]{2,2},3);
        System.out.println(Arrays.toString(arrsy));

    }
}
