package l;

import java.util.ArrayList;
import java.util.List;

public class LeetCode046 {
    public static void main(String[] args) {
        System.out.println("keep Happy boy");
    }

    /**
     Given an array nums of distinct integers, return all the possible permutations.
     You can return the answer in any order.

     Example 1:

     Input: nums = [1,2,3]
     Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     Example 2:

     Input: nums = [0,1]
     Output: [[0,1],[1,0]]
     Example 3:

     Input: nums = [1]
     Output: [[1]]


     Constraints:

     1 <= nums.length <= 6
     -10 <= nums[i] <= 10
     All the integers of nums are unique.
     */

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,nums,new ArrayList<Integer>(),0);
        return result;
    }

    private static void backtracking(List<List<Integer>> result, int[] nums, ArrayList<Integer> integers, int i) {
        if(integers.size() == nums.length ){
            result.add(new ArrayList<>(integers));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(!integers.contains(nums[j])){
                integers.add(nums[j]);
                backtracking(result,nums,integers,i+1);
                integers.remove(integers.size()-1);
            }
        }
    }
}
