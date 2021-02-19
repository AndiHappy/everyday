package l;
//Given an input string (s) and a pattern (p), implement regular expression matc
//hing with support for '.' and '*' where: 
//
// 
// '.' Matches any single character. 
// '*' Matches zero or more of the preceding element. 
// 
//
// The matching should cover the entire input string (not partial). 
//
// 
// Example 1: 
//
// 
//Input: s = "aa", p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".
// 
//
// Example 2: 
//
// 
//Input: s = "aa", p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, 
//by repeating 'a' once, it becomes "aa".
// 
//
// Example 3: 
//
// 
//Input: s = "ab", p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
// 
//
// Example 4: 
//
// 
//Input: s = "aab", p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, i
//t matches "aab".
// 
//
// Example 5: 
//
// 
//Input: s = "mississippi", p = "mis*is*p*."
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s contains only lowercase English letters. 
// p contains only lowercase English letters, '.', and '*'. 
// It is guaranteed for each appearance of the character '*', there will be a pr
//evious valid character to match.
//
// Related Topics String Dynamic Programming Backtracking

public class LeetCode010 {

    public static boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        //dp[i][j] represent:  s[i] is pattern p[j]
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // init 
        dp[0][0] = true;

        // dp[i][0] is false represent:s="ssdd",p="",so is false;
        //init: dp[0][j]
        for(int j = 1;j< dp[0].length ; j++){
            if(p.charAt(j-1) == '*' && (dp[0][j-1] || j>1 && dp[0][j-2])){
                dp[0][j]=true;
            }
        }

        // initialize dp
        for(int i=1;i<dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                // s[i] == p[j],for example: “aa” == “aa” , so: dp[i][j] = dp[i-1][j-1]
                // p[j] = '.' so: dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                if(p.charAt(j-1) == '*'){
                    // for example (aa ,a*)  or (aa ,.*)
                    // i j 第几个字符，在dp的数组中指代，所以在s,p的下标就是i-1,j-1

                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-1) == '.' ){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        // dp[i][j-2], a* means ""
                        // dp[i][j-1], a* means "a"
                        // dp[i-1][j], a* means "aa"
                        dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }

                }
            }
        }
        
        

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println("hello holiaday!");
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a."));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", "a*ab"));
        System.out.println(isMatch("aa", "ca*ab"));
    }
}