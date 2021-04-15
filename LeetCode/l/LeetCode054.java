package l;

import java.util.ArrayList;
import java.util.List;

public class LeetCode054 {

    /**
     54. Spiral Matrix
     Given an m x n matrix, return all elements of the matrix in spiral order.

     Example 1:

     Input: matrix = [
     [1,2,3],
     [4,5,6],
     [7,8,9]]
     Output: [1,2,3,6,9,8,7,4,5]
     Example 2:


     Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     Output: [1,2,3,4,8,12,11,10,9,5,6,7]


     Constraints:

     m == matrix.length
     n == matrix[i].length
     1 <= m, n <= 10
     -100 <= matrix[i][j] <= 100

     */

    public static void main(String[] args) {
        System.out.println("keep Happy boy");

        int[][] matrx=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        System.out.println(spiralOrder_new(matrx));

        matrx=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(spiralOrder_new(matrx));
    }

    /***
     lefttop[0][1] ...............righttop[0][1]
     .                               .
     .                               .
     leftbotom[0][1].............rightbotom[0][1]
     * */

    public static  List<Integer> spiralOrder_new(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[] lefttop = new int[]{0,0};
        int[] righttop = new int[]{0,n-1};
        int[] leftbotom = new int[]{m-1,0};
        int[] rightbotom = new int[]{m-1,n-1};

        while(ans.size() < m*n){

            for (int i = lefttop[1]; i <= righttop[1] && ans.size() < m*n; i++) {
                ans.add(matrix[lefttop[0]][i]);
            }
            lefttop[0]++;
            righttop[0]++;

            for (int i = righttop[0]; i <= rightbotom[0] && ans.size() < m*n ; i++) {
                ans.add(matrix[i][rightbotom[1]]);
            }
            righttop[1]--;
            rightbotom[1]--;

            for (int i = rightbotom[1]; i >=leftbotom[1] && ans.size() < m*n; i--) {
                ans.add(matrix[rightbotom[0]][i]);
            }
            rightbotom[0]--;
            leftbotom[0]--;

            for (int i = leftbotom[0]; i >=lefttop[0] && ans.size() < m*n; i--) {
                ans.add(matrix[i][leftbotom[1]]);
            }
            lefttop[1]++;
            leftbotom[1]++;
        }


        return ans;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = n-1;
        int top = 0, bottom = m-1;

        List<Integer> ans = new ArrayList<>();

        while(ans.size() < m*n){

            for(int j=left; j<=right && ans.size() < m*n ; j++){
                ans.add(matrix[top][j]);
            }
            top++;

            for(int i = top; i<=bottom && ans.size() < m*n ; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            for(int j=right; j>=left && ans.size() < m*n; j--){
                ans.add(matrix[bottom][j]);
            }
            bottom--;

            for(int i=bottom; i>=top && ans.size() < m*n; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }

        return ans;
    }
}
