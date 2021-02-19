package l;

import java.util.Stack;

public class LeetCode032 {

    /**
     Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.



     Example 1:

     Input: s = "(()"
     Output: 2
     Explanation: The longest valid parentheses substring is "()".
     Example 2:

     Input: s = ")()())"
     Output: 4
     Explanation: The longest valid parentheses substring is "()()".
     Example 3:

     Input: s = ""
     Output: 0


     Constraints:

     0 <= s.length <= 3 * 104
     s[i] is '(', or ')'.

     * **/

    public static boolean validate(String s){
        if(null == s || s.length() <= 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(')' == s.charAt(i)){
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.peek();
                }else if('(' == s.charAt(i)){
                    stack.push(')');
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (validate(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;

    }

  
    public static int longestValidParentheses_dp(String s) {
        int[] dp = new int[s.length()];
        return  -1;
    }

    public int longestValidParentheses_stack(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(longestValidParentheses("()()("));
    }
}
