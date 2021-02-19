package l;

import java.util.ArrayList;
import java.util.List;

public class LeetCode017 {
    /*
    Given a string containing digits from 2-9 inclusive,

    return all possible letter combinations that the number could represent.

    Return the answer in any order.

    A mapping of digit to letters (just like on the telephone buttons)
    is given below. Note that 1 does not map to any letters.


    {0 ==> "",
     1 ==> "",
     2 ==> "abc",
     3 ==> "def",
     4 ==> "ghi",
     5 ==> "lkj",
     6 ==> "mno",
     7 ==> "pqrs",
     8 ==> "tuv",
     9 ==> "wxyz"};


    Example 1:

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

    Example 2:
    Input: digits = ""
    Output: []


    Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]


    Constraints:
            0 <= digits.length <= 4

    digits[i] is a digit in the range ['2', '9'].
    */

    static String[] digitsCombina = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "lkj",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        return letterCombinations(digits, 0, digitsCombina,result);
    }

    //
    private static List<String> letterCombinations(String digits, int i, String[] digitsCombina, List<String> result) {
        if(i < digits.length()){
            // find i
            List<String> tmpR = new ArrayList<>();
            int index = digits.charAt(i)-'0';
            String dividedString = digitsCombina[index];
            if(result==null || result.isEmpty()){
                for (int j = 0; j < dividedString.length(); j++) {
                    tmpR.add(String.valueOf(dividedString.charAt(j)));
                }
            }else{
                for (String tmp: result) {
                    for (int j = 0; j < dividedString.length(); j++) {
                        tmpR.add(tmp+dividedString.charAt(j));
                    }
                }
            }
            return letterCombinations(digits,i+1,digitsCombina,tmpR);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("L1_30.LeetCode017.main");
        System.out.println( letterCombinations("23"));
    }
}
