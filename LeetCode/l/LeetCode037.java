package l;

import java.util.Arrays;

public class LeetCode037 {
    /**
     * 37. Sudoku Solver

     Write a program to solve a Sudoku puzzle by filling the empty cells.

     A sudoku solution must satisfy all of the following rules:

     Each of the digits 1-9 must occur exactly once in each row.
     Each of the digits 1-9 must occur exactly once in each column.
     Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     The '.' character indicates empty cells.



     Example 1:

     Input: board =
     [["5","3",".",".","7",".",".",".","."],
     ["6",".",".","1","9","5",".",".","."],
     [".","9","8",".",".",".",".","6","."],
     ["8",".",".",".","6",".",".",".","3"],
     ["4",".",".","8",".","3",".",".","1"],
     ["7",".",".",".","2",".",".",".","6"],
     [".","6",".",".",".",".","2","8","."],
     [".",".",".","4","1","9",".",".","5"],
     [".",".",".",".","8",".",".","7","9"]]

     Output:
     [["5","3","4","6","7","8","9","1","2"],
     ["6","7","2","1","9","5","3","4","8"],
     ["1","9","8","3","4","2","5","6","7"],
     ["8","5","9","7","6","1","4","2","3"],
     ["4","2","6","8","5","3","7","9","1"],
     ["7","1","3","9","2","4","8","5","6"],
     ["9","6","1","5","3","7","2","8","4"],
     ["2","8","7","4","1","9","6","3","5"],
     ["3","4","5","2","8","6","1","7","9"]]

     Explanation: The input board is shown above and the only valid solution is shown below:


     Constraints:

     board.length == 9
     board[i].length == 9
     board[i][j] is a digit or '.'.
     It is guaranteed that the input board has only one solution.


     * */

    public static void  solveSudoku(char[][] board) {

        if(null == board || board.length == 0) return ;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board)) {
                                return true;
                            }else{
                                board[i][j]='.';
                            }
                        }
                    }
                    // loop '1' ==> '9' no right answer
                    return false;
                }
            }
        }
        // all numsbers
        return true;
    }


    private static boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    //-----------------------------------------------------------------------------------------------------------
/**
 *
 * To think about that,
 * recursion will brutal force try all the board[i][j],
 * backtrack(board, i, j + 1) and backtrack(board, i + 1, j)
 * do that job, so the double-for loop is redundant.
 *
 * The original straightforward solution works fine because we only need one solution:
 */
    public void solveSudoku_backtrack(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;
        if (j == n) {
            // reach the last column, next row
            return backtrack(board, i + 1, 0);
        }
        if (i == m) {
            // reach the last row, finish
            return true;
        }

        if (board[i][j] != '.') {
            // preset number, skip
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // conflict with others, skip
            if (!isValid_backtrack(board, i, j, ch))
                continue;

            board[i][j] = ch;
            // have found a solution, stop
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        // for this grid, 1~9 all fail
        return false;
    }

    boolean isValid_backtrack(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // row
            if (board[r][i] == n) return false;
            // column
            if (board[i][c] == n) return false;
            // 3 x 3
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        char[][] boead = new char[][] {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        for (int i = 0; i < boead.length; i++) {
            System.out.println(Arrays.toString(boead[i]));

        }

        solveSudoku(boead);

        System.out.println("-----------------------------------------");

        for (int i = 0; i < boead.length; i++) {
            System.out.println(Arrays.toString(boead[i]));

        }
    }

}
