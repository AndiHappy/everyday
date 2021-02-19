package l;//Given a 32-bit signed integer, reverse digits of an integer.
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows. 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 

public class LeetCode007 {
    
    public static int change(int a) {
        int flag = a > 0 ? 1 : -1;
        if (a < 0)
            a = Math.abs(a);
        int result = 0;
        while (a > 0) {
            int tmp = a % 10;
            if (result > (Integer.MAX_VALUE - tmp) / 10) {
                return 0;
            }
            result = result * 10 + tmp;
            a = a / 10;
        }
        return result * flag;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(change(2147483647));// 7463847421
    }
}
