package util;

import java.util.Stack;

public class Parenthesees {

    public  static boolean validateParentheses(String s){
        if(s == null || s.length() == 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if('(' == s.charAt(i)){
                stack.push(s.charAt(i));
            }else if(')' == s.charAt(i) && !stack.isEmpty() && stack.peek() == '('){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }
    
}
