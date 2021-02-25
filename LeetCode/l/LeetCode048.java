package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode048 {

    /**
     47. Permutations II

     Given a collection of numbers, nums, that might contain duplicates,
     return all possible unique permutations in any order.

     Example 1:

     Input: nums = [1,1,2]
     Output:
     [[1,1,2],
     [1,2,1],
     [2,1,1]]
     Example 2:

     Input: nums = [1,2,3]
     Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


     Constraints:

     1 <= nums.length <= 8
     -10 <= nums[i] <= 10

     */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);

        matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
    }
    //Input: matrix = [
    // [1,2,3],
    // [4,5,6],
    // [7,8,9]]

    // [1,4,7],
    // [2,5,8],
    // [3,6,9]]

    // [7,4,1],
    // [8,5,2],
    // [9,6,3]]


//
// [5,1,9,11],
// [2,4,8,10],
// [13,3,6,7],
// [15,14,12,16]

// [5,2, 13, 15],
// [1,4, 3,  14],
// [9,8 ,6,  12],
// 11,10,7,16]


// [15,13,2,5],
// [14,3,4,1],
// [12,6,8,9],
// [16,7,10,11]]
//

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }

        // change 180
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i>=j) continue;
                swap(matrix,i,j);
            }
        }

        System.out.println("----------------------------");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < matrix.length; i++) {
            int j = 0,k = matrix[0].length-1;
            while(j<k){
                swap(matrix,i,j,k);
                j++;k--;
            }

        }

        System.out.println("----------------------------");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void swap(int[][] matrix, int i, int j, int k) {
        int value = matrix[i][j];
        matrix[i][j] = matrix[i][k];
        matrix[i][k] = value;
    }


    private static void swap(int[][] matrix, int i, int j) {
        int value = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = value;
    }
}
