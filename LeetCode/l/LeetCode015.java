package l;//Given an array nums of n integers, are there elements a, b, c in nums such tha
//t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
//ro. 
//
// Notice that the solution set must not contain duplicate triplets. 
//
// 
// Example 1: 
// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Example 2: 
// Input: nums = []
//Output: []
// Example 3: 
// Input: nums = [0]
//Output: []
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode015 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        if(nums == null || nums.length < 1) return result;

        // sort
        Arrays.sort(nums);

        // two points
        for (int i = 0; i < nums.length-2 ; i++) {
            if(nums[i] >0) break;
            // skip same element
            if(i>0 && nums[i-1] == nums[i]) continue;
            int j= i+1,k= nums.length-1;
            while(j<k){
                if(j>i+1 && nums[j-1] == nums[j]){
                    j++;
                    continue;
                }
                int tmpSum = nums[i]+nums[j]+nums[k];
                if(tmpSum == 0){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(tmpSum > 0){
                    k--;
                }else {
                    j++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-1,-1,0,1,2}));
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));

    }
}
