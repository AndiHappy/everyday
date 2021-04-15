package l;

import java.util.*;

public class LeetCode051 {

    public static void main(String[] rags) {
//        getCarNum("/Users/didi/xiamen");
        List<List<String>> result = queue(5);
        for (List<String> value :
                result) {
            for (String value1 :
                    value) {
                System.out.println();
                System.out.println(value1);
            }
            System.out.println();
        }
    }

    public static List<List<String>> queue(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> slid1 = new HashSet<Integer>();
        Set<Integer> slid2 = new HashSet<Integer>();
        backtracking(result, queues, 0, n, columns, slid1, slid2);
        return result;
    }

    private static void backtracking(List<List<String>> result, int[] queues, int row, int n, Set<Integer> columns, Set<Integer> slid1, Set<Integer> slid2) {
        if (row == n) {
            List<String> tmp = generate(queues, n);
            result.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!columns.contains(i) && !slid1.contains(row + i) && !slid2.contains(row - i)) {
                columns.add(i);
                slid1.add(row + i);
                slid2.add(row - i);
                // put the queue
                queues[row] = i;
                backtracking(result, queues, row + 1, n, columns, slid1, slid2);
                queues[row] = -1;
                columns.remove(i);
                slid1.remove(row + i);
                slid2.remove(row - i);
            }
        }
    }

    private static List<String> generate(int[] queues, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] queueindex = new char[n];
            Arrays.fill(queueindex, '.');
            queueindex[queues[i]] = 'Q';
            result.add(new String(queueindex));
        }
        return result;
    }
}
