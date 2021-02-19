package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode018 {

    //Given an array nums of n integers and an integer target, are there elements a,
// b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets
// in the array which gives the sum of target.
//
// Notice that the solution set must not contain duplicate quadruplets.
//
//
// Example 1:
// Input: nums = [1,0,-1,0,-2,2], target = 0
//Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// Example 2:
// Input: nums = [], target = 0
//Output: []
//
//
// Constraints:
//
//
// 0 <= nums.length <= 200
// -109 <= nums[i] <= 109
// -109 <= target <= 109
//
// Related Topics Array Hash Table Two Pointers
// 👍 2760 👎 382

    // Notice that the solution set must not contain duplicate quadruplets.
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            // skip same element
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                // skip same elements
                if(j>i+1 && nums[j-1] == nums[j]) continue;

                int m = j+1;int n = nums.length-1;
                while(m < n){
                    // skip same elements
                    if(m > j+1 && nums[m-1] == nums[m]){
                        m++;
                        continue;
                    }
                    int tmpSum = nums[i]+nums[j]+nums[m]+nums[n];
                    if(tmpSum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;
                        n--;

                    }else if(tmpSum < target){
                        m++;
                    }else {
                        n--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("keep happy");

        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));

        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5},-11));


    }


}
