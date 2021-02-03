import java.util.Stack;

import util.Parenthesees;

public class Test {

    public static  int longestValidParentheses(String s){
        int maxLen = 0;
        for(int i = 0 ; i < s.length(); i ++ ){
            for (int j = i+2; j <= s.length(); j+=2) {
                String tmp = s.substring(i, j);
                if(Parenthesees.validateParentheses(tmp)){
                    maxLen = Math.max(maxLen, j-i);
                }
            }
        }
        return maxLen;
    }

    public static boolean validateParentheses(String s) {
        if (s == null || s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else if (')' == s.charAt(i) && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * ())((())
     * 
     * 
     */
    public static int longestValidParentheses_dp(String s){
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int maxans = 0;
        for (int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i>=2? dp[i-2]:0)+2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()"));
        System.out.println(longestValidParentheses("()((())"));
    }
}
