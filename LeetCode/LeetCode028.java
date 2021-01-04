public class LeetCode028 {

    /**

     Implement strStr().

     Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

     Clarification:

     What should we return when needle is an empty string? This is a great question to ask during an interview.

     For the purpose of this problem, we will return 0 when needle is an empty string.
     This is consistent to C's strstr() and Java's indexOf().


     Example 1:

     Input: haystack = "hello", needle = "ll"
     Output: 2
     Example 2:

     Input: haystack = "aaaaa", needle = "bba"
     Output: -1
     Example 3:

     Input: haystack = "", needle = ""
     Output: 0


     Constraints:

     0 <= haystack.length, needle.length <= 5 * 104
     haystack and needle consist of only lower-case English characters.

     *
     * */

    /**
     * 这道题目有意思，需要仔细的想一遍
     *
     * */
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null || needle.length() > haystack.length()) return -1;

        int len = haystack.length(), i = 0, j = 0, pos = 0;
        while(i < len && j < needle.length()) {
            if(haystack.charAt(i++) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
                pos = i;
            }
        }
        return j == needle.length()? pos : -1;
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");

    }
}
