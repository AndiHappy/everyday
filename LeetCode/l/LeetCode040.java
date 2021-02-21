package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode040 {

    /**
     Given a collection of candidate numbers (candidates) and a target number (target),
     find all unique combinations in candidates where the candidate numbers sum to target.

     Each number in candidates may only be used once in the combination.

     Note: The solution set must not contain duplicate combinations.



     Example 1:

     Input: candidates = [10,1,2,7,6,1,5], target = 8
     Output:
     [
     [1,1,6],
     [1,2,5],
     [1,7],
     [2,6]
     ]
     Example 2:

     Input: candidates = [2,5,2,1,2], target = 5
     Output:
     [
     [1,2,2],
     [5]
     ]


     Constraints:

     1 <= candidates.length <= 100
     1 <= candidates[i] <= 50
     1 <= target <= 30
     */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        List<List<Integer>> res = combinationSum2(new int[]{10,1,2,7,6,1,5},8);
        for (List<Integer> tmp : res) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // first sort the canditates
        Arrays.sort(candidates);
        backtracking(candidates,target,result,new ArrayList<Integer>(),0);
        return result;
    }

    private static void backtracking(int[] candidates, int target, List<List<Integer>> result, ArrayList<Integer> integers, int i) {
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(integers));
        }else{
            for (int j = i; j < candidates.length ; j++) {
                // how to judge element same  value and different index
                if(j > i && candidates[j] == candidates[j-1]) continue;

                // 这句的剪枝，错误在什么地方？？？？ 限制的条件，条件中的"唯一" 不一致
//                if(j > 0 && candidates[j] == candidates[j-1]) continue;

                integers.add(candidates[j]);
                backtracking(candidates,target-candidates[j],result,integers,j+1); //Each number in candidates may only be used once in the combination.
                integers.remove(integers.size()-1);
            }
        }
    }
}
