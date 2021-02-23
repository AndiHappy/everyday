package l;

/**
 *
 * Related Topics Array
 *
 * */
public class LeetCode041 {

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
    }

    /**
     *
     Given an unsorted integer array nums, find the smallest missing positive integer.
      Example 1:
      Input: nums = [1,2,0]
     Output: 3
      Example 2:
      Input: nums = [3,4,-1,1]
     Output: 2
      Example 3:
      Input: nums = [7,8,9,11,12]
     Output: 1


      Constraints:
      0 <= nums.length <= 300
      -231 <= nums[i] <= 231 - 1

      Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?

     */

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // make all numbers positive or not bigger than  n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n+1;
            }
        }

        // all numbers is in [1... n+1]
        // make 2 to n+1 is -1
        for (int i=0; i< n;i++){
            if(nums[i]> n ) continue;
            int value = Math.abs(nums[i]);
            if(nums[value] > 0){
                nums[value] = -1*nums[value];
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return n+1;
    }

    /**
     * In case, someone don't understand the solution, here it is in very simple words -
     * once all numbers are made positive, : first made all numbers positive
     *
     * if any number is found in range [1,N] then attach -ve sign to the corresponding index.
     * So for 1, 0th element becomes -ve, for 2 it is 1st considering 0 based index.
     *
     * That's all
     * */
    public static int firstMissingPositive_second (int[] nums) {
        int n = nums.length;

        // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
        // (we can ignore those because if all number are > n then we'll simply return 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // note: all number in the array are now positive, and on the range 1..n+1
        // 2. mark each cell appearing in the array, by converting the index for that number to negative
        for (int i = 0; i < n; i++) {

            if (Math.abs(nums[i]) > n) {
                continue;
            }
            int num = Math.abs(nums[i]);

            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }

        // 3. find the first cell which isn't negative (doesn't appear in the array)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        // 4. no positive numbers were found, which means the array contains all numbers 1..n
        return n + 1;
    }

    public int firstMissingPositive_change (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1)    return i+1;
        }
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
