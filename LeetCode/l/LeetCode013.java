package l;

import java.util.HashMap;
import java.util.Map;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added togeth
//er. 12 is written as XII, which is simply X + II. The number 27 is written as XX
//VII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: s = "IV"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "IX"
//Output: 9
// 
//
// Example 4: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics Math String 
// 👍 2800 👎 3846

public class LeetCode013 {

    // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    static Map<Character, Integer> comvertMap = new HashMap<Character, Integer>();
    static {
        comvertMap.put('a', 0);
        comvertMap.put('I', 1);
        comvertMap.put('V', 5);
        comvertMap.put('X', 10);
        comvertMap.put('L', 50);
        comvertMap.put('C', 100);
        comvertMap.put('D', 500);
        comvertMap.put('M', 1000);
    }

    public static int romanToInt(String s) {
        char[] tmp = s.toCharArray();
        int result = 0;
        for (int i = 0; i < tmp.length; i++) {
            char tmpchar = tmp[i];
            char tmpafter = i + 1 >= tmp.length ? 'a' : tmp[i + 1];
            result = (comvertMap.get(tmpchar) >= comvertMap.get(tmpafter)) ? (result + comvertMap.get(tmpchar))
                    : (result - comvertMap.get(tmpchar));
        }

        return result;

    }

    public static void main(String[] args) {
        
        System.out.println("hello holiday");

        System.out.println(romanToInt("MLC"));
    }
    
}
