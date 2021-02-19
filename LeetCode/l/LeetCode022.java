package l;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode022 {

    //Given n pairs of parentheses, write a function to generate all combinations of
// well-formed parentheses.
//
//
// Example 1:
// Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]
// Example 2:
// Input: n = 1
//Output: ["()"]
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics String Backtracking

    /**
     * 1 ==> ()
     * 2 ==> ()(),(())
     * 3 ==> "((()))","(()())","(())()","()(())","()()()"
     * */
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Set<String> judge = new HashSet<>();
        // 第一种解法 
        generateParenthesis(result,"",0,0,n);

        return generateParenthesis(1,result,judge,n);
    }


    /**
     *  回溯算法中，如何返回最后的结果值
     *  是如何递进推荐的
     * */
    private static  List<String>  generateParenthesis(int i, List<String> result,Set<String> judge, int n) {
        if( i == 1 ) {
            result.add("()");
            judge.add("()");
            return generateParenthesis(i+1,result,judge,n);
        }
        if(i > n) return result;

        List<String> resChange = new ArrayList<>();
        if(!result.isEmpty()){
            for (int j = 0; j < result.size() ; j++) {
                String tmp = result.get(j);
                for (int k = 0; k < tmp.length(); k++) {
                    String tmpBuilder = tmp.substring(0,k)+"()"+ tmp.substring(k,tmp.length());
                    if(!judge.contains(tmpBuilder)) {
                        judge.add(tmpBuilder);
                        resChange.add(tmpBuilder);
                    }
                }
            }
        }
        resChange =  generateParenthesis(i+1,resChange,judge,n);
        return resChange;
    }

    /*
    * key: 观察出来这个规律，并且能够编码出来，很厉害，值得学习
    * */
    private static void generateParenthesis(List<String> result, String curRes,
                                            int open, int close, int max) {
        if(curRes.length() == max*2){
            result.add(curRes);
            return ;
        }

        if(open < max) {
            generateParenthesis(result, curRes + "(", open + 1, close, max);
        }
        if(close < open){
            generateParenthesis(result,curRes+")",open,close+1,max);
        }
    }


    public static void main(String[] args) {
        System.out.println("keep happy");
        System.out.println(generateParenthesis(3));
    }
}
