package l;

import java.util.HashSet;
import java.util.Set;

public class LeetCode036 {

    /**
     36. Valid Sudoku

     Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

     Each row must contain the digits 1-9 without repetition.

     Each column must contain the digits 1-9 without repetition.

     Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

     Note:

     A Sudoku board (partially filled) could be valid but is not necessarily solvable.

     Only the filled cells need to be validated according to the mentioned rules.

     Example 1:


     Input: board =
     [["5","3",".",".","7",".",".",".","."]
     ,["6",".",".","1","9","5",".",".","."]
     ,[".","9","8",".",".",".",".","6","."]
     ,["8",".",".",".","6",".",".",".","3"]
     ,["4",".",".","8",".","3",".",".","1"]
     ,["7",".",".",".","2",".",".",".","6"]
     ,[".","6",".",".",".",".","2","8","."]
     ,[".",".",".","4","1","9",".",".","5"]
     ,[".",".",".",".","8",".",".","7","9"]]
     Output: true
     Example 2:

     Input: board =
     [["8","3",".",".","7",".",".",".","."]
     ,["6",".",".","1","9","5",".",".","."]
     ,[".","9","8",".",".",".",".","6","."]
     ,["8",".",".",".","6",".",".",".","3"]
     ,["4",".",".","8",".","3",".",".","1"]
     ,["7",".",".",".","2",".",".",".","6"]
     ,[".","6",".",".",".",".","2","8","."]
     ,[".",".",".","4","1","9",".",".","5"]
     ,[".",".",".",".","8",".",".","7","9"]]
     Output: false
     Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.


     Constraints:

     board.length == 9
     board[i].length == 9
     board[i][j] is a digit or '.'.

     * */

    /*
    Collect the set of things we see, encoded as strings. For example:

            '4' in row 7 is encoded as "(4)7".
            '4' in column 7 is encoded as "7(4)".
            '4' in the top-right block is encoded as "0(4)2".
    Scream false if we ever fail to add something because it was already added (i.e., seen before).
    */

    public boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }

//    Edit: Just occurred to me that we can also make it really clear and self-explaining. I'm loving it.

    public boolean isValidSudoku_readable(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

}
