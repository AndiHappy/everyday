package l;

import java.util.*;

public class LeetCode052 {

    public static void main(String[] args) {
        System.out.println("keep Happy boy");
        System.out.println(totalNQueens(4));
    }

    public  static int totalNQueens(int n) {
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> slid1 = new HashSet<Integer>();
        Set<Integer> slid2 = new HashSet<Integer>();
        return backtracking(queues, 0, n, columns, slid1, slid2);
    }

    private static int backtracking(int[] queues, int row, int n, Set<Integer> columns, Set<Integer> slid1, Set<Integer> slid2) {
        if (row == n) {
            return 1 ;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!columns.contains(i) && !slid1.contains(row + i) && !slid2.contains(row - i)) {
                columns.add(i);
                slid1.add(row + i);
                slid2.add(row - i);
                // put the queue
                queues[row] = i;
                result = result +backtracking(queues, row + 1, n, columns, slid1, slid2);
                queues[row] = -1;
                columns.remove(i);
                slid1.remove(row + i);
                slid2.remove(row - i);
            }
        }
        return result;
    }
}
