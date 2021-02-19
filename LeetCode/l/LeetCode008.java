package l;//Implement atoi which converts a string to an integer.
//
// The function first discards as many whitespace characters as necessary until 
//the first non-whitespace character is found. Then, starting from this character 
//takes an optional initial plus or minus sign followed by as many numerical digit
//s as possible, and interprets them as a numerical value. 
//
// The string can contain additional characters after those that form the integr
//al number, which are ignored and have no effect on the behavior of this function
//. 
//
// If the first sequence of non-whitespace characters in str is not a valid inte
//gral number, or if no such sequence exists because either str is empty or it con
//tains only whitespace characters, no conversion is performed. 
//
// If no valid conversion could be performed, a zero value is returned. 
//
// Note: 
//
// 
// Only the space character ' ' is considered a whitespace character. 
// Assume we are dealing with an environment that could only store integers with
//in the 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is o
//ut of the range of representable values, 231 − 1 or −231 is returned. 
// 
//
// 
// Example 1: 
//
// 
//Input: str = "42"
//Output: 42
// 
//
// Example 2: 
//
// 
//Input: str = "   -42"
//Output: -42
//Explanation: The first non-whitespace character is '-', which is the minus sig
//n. Then take as many numerical digits as possible, which gets 42.
// 
//
// Example 3: 
//
// 
//Input: str = "4193 with words"
//Output: 4193
//Explanation: Conversion stops at digit '3' as the next character is not a nume
//rical digit.
// 
//
// Example 4: 
//
// 
//Input: str = "words and 987"
//Output: 0
//Explanation: The first non-whitespace character is 'w', which is not a numeric
//al digit or a +/- sign. Therefore no valid conversion could be performed.
// 
//
// Example 5: 
//
// 
//Input: str = "-91283472332"
//Output: -2147483648
//Explanation: The number "-91283472332" is out of the range of a 32-bit signed 
//integer. Thefore INT_MIN (−231) is returned.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 200 
// s consists of English letters (lower-case and upper-case), digits, ' ', '+', 
//'-' and '.'. 
// 

public class LeetCode008 {

    public static int myAtoi(String s) {
        // exception judge
        if (s == null || s.length() == 0)
            return 0;

        char[] chararray = s.toCharArray();

        // The function first discards as many whitespace characters as necessary until
        // the first non-whitespace character is found
        int result = 0;
        int flag = 1;
        int cur = 0;
        while (cur < s.length() && chararray[cur] == ' ')
            cur++;

        // starting from this character takes an optional initial plus or minus sign
        if (cur < s.length() && chararray[cur] == '-') {
            flag = -1;
            cur++;
        } else if (cur < s.length() && chararray[cur] == '+') {
            flag = 1;
            cur++;
        }

        // followed by as many numerical digits as possible, and interprets them as a
        // numerical value
        while (cur < s.length() && Character.isDigit(chararray[cur])) {
            int tmp = chararray[cur] - '0';
            // Assume we are dealing with an environment that could only store integers with
            // in the 32-bit signed integer range: [−231, 231 − 1]. If the numerical value
            // is out
            // of the range of representable values, 231 − 1 or −231 is returned
            if ((Integer.MAX_VALUE - tmp) / 10 < result) {
                return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                result = result * 10 + tmp;
            }
            cur++;
        }
        return flag * result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -3293923"));
        System.out.println(myAtoi("  00033223"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483648"));
        System.out.println(myAtoi("-2147483649"));
    }
}
