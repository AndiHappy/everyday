package l;

public class LeetCode038 {

    /**
     38. Count and Say

     The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

     countAndSay(1) = "1"

     countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1),
     which is then converted into a different digit string.

     To determine how you "say" a digit string, split it into the minimal number of groups
     so that each group is a contiguous section all of the same character.
     Then for each group, say the number of characters, then say the character.
     To convert the saying into a digit string, replace the counts with
     a number and concatenate every saying.



     For example, the saying and conversion for digit string "3322251":


     Given a positive integer n, return the nth term of the count-and-say sequence:23321211.



     Example 1:
     Input: n = 1
     Output: "1"

     Explanation: This is the base case.

     Example 2:
     Input: n = 4
     Output: "1211"

     Explanation:
     countAndSay(1) = "1"
     countAndSay(2) = say "1" = one 1 = "11"
     countAndSay(3) = say "11" = two 1's = "21"
     countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"


     Constraints:

     1 <= n <= 30

     *
     * */

    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else if(n == 2){
            return "11";
        }else if(n == 3) {
            return "21";
        }else {
            String result = countAndSay(n-1);
            return countAndSay(result);
        }
    }

    private static String countAndSay(String result) {
        StringBuilder res = new StringBuilder();
        char[] array = result.toCharArray();
        int i = 0 ; char cur = array[0];
        for (int j = 0; j < array.length; j++) {
            if(cur == array[j]){
                i++;
            }else{
                res.append(i).append(cur);
                i=1;
                cur=array[j];
            }
        }
        if(i > 0) res.append(i).append(cur);
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println("keep Happy boy");
//        System.out.println(countAndSay(1));
//        System.out.println(countAndSay(2));
//        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
//        System.out.println(countAndSay(7));
//        System.out.println(countAndSay(8));
//        System.out.println(countAndSay(9));
//        System.out.println(countAndSay(10));

    }
}
