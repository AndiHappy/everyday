package l;

import java.util.Stack;

public class LeetCode020 {

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
// determine if the input string is valid.
//
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
//Input: s = "()"
//Output: true
//
//
// Example 2:
//
//
//Input: s = "()[]{}"
//Output: true
//
//
// Example 3:
//
//
//Input: s = "(]"
//Output: false
//
//
// Example 4:
//
//
//Input: s = "([)]"
//Output: false
//
//
// Example 5:
//
//
//Input: s = "{[]}"
//Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
    public static boolean isValid(String s) {
        if(s == null || s.length() <1 ) return true;
        Stack<Character> stack = new Stack<>();
        char[] schars = s.toCharArray();
        for (int i = 0; i < schars.length; i++) {
            char c = schars[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else if(c == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("keep happy");
        System.out.println(isValid("("));
        System.out.println(isValid(")"));
        System.out.println(isValid("()["));
        System.out.println(isValid("()[{}]"));
    }

}
