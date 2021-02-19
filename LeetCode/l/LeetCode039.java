package l;

import java.util.*;

public class LeetCode039 {




    public static void main(String[] args) {
        System.out.println("keep Happy boy");
//        casetest(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},10);
        casetest(new int[]{2,3,6,7},7);
//        casetest(new int[]{2,3,5},8);
//        casetest(new int[]{2},1);
//        casetest(new int[]{1},1);
//        casetest(new int[]{1},2);
//        casetest(new int[]{2,7,6,3,5,1},9);

    }

    public static void casetest(int[] rags,int target) {
        int[] result = rags;
        List<List<Integer>> res = combinationSum(rags,target);
        for (List<Integer> tmp : res) {
            System.out.println(Arrays.toString(tmp.toArray()));
        }
    }

    /**
     * why sorts?
     * why start i ? // ①
     * */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtracking(candidates, res, new ArrayList<>(), target,0);
        return res;
    }

    private static void backtracking(int[] candidates, ArrayList<List<Integer>> res, ArrayList<Integer> restmp, int target, int start) {
        if(target < 0) return;
        if(0 == target){
            res.add(new ArrayList<>(restmp));
        }else{
            for (int i = start; i < candidates.length ; i++) {
//                if(candidates[i] <= target){
                    restmp.add(candidates[i]);
//                    backtracking(candidates,res,restmp,target-candidates[i],start); ①
                backtracking(candidates,res,restmp,target-candidates[i],i);
                    restmp.remove(restmp.size()-1);
//                }
            }
        }
    }






/*

    /**
     * 明显的看出来，这个backtracking的算法，只是模仿了具体的框架性的代码，没有做好"剪枝"的工作

//    ------------------------------ ------------------------------ ------------------------------ ------------------------------

    private static void backtracking(int[] result, ArrayList<List<Integer>> res, ArrayList<Integer> restmp, int target) {
        // condition limit
        if (meetCondition(target,restmp,res)) {
            res.add(new ArrayList<Integer>(restmp));
            return;
        }

        // not meet condition
        for (int i = 0; i < result.length; i++) {
            int tmpTarget = target - result[i];
            if (tmpTarget >= 0) {
                restmp.add(result[i]);
                // track.....
                backtracking(result, res, restmp, tmpTarget);
                // back.....
                restmp.remove(restmp.size() - 1);
            }
        }
    }

    private static boolean meetCondition(int target, ArrayList<Integer> restmp, ArrayList<List<Integer>> res) {
        if(0 == target){
            // res中不包含restmp，返回true
            if(res.isEmpty()) return true;

            //遍历res，如果其中有一个和restmp相等，则返回false，其余的情况返回true
            return meetCondition(res,restmp);
        }
        return false;
    }

    //遍历res，如果其中有一个和restmp相等，则返回false，其余的情况返回true
    private static boolean meetCondition(ArrayList<List<Integer>> res, ArrayList<Integer> restmp) {

        for (List<Integer> tmp : res) {
            if(tmp.size() == restmp.size() && issame(tmp,restmp)) return false;
        }

        return true;
    }

    private static boolean issame(List<Integer> tmp1, ArrayList<Integer> restmp1) {
        List<Integer> tmp = new ArrayList<>(tmp1);
        ArrayList<Integer> restmp = new ArrayList<>(restmp1);
        Collections.sort(restmp);
        Collections.sort(tmp);
        for (int i = 0; i <restmp.size() ; i++) {
            if(restmp.get(i) != tmp.get(i)) return false;
        }
        return true;
    }

    //    ------------------------------ ------------------------------ ------------------------------ ------------------------------

* */

}
