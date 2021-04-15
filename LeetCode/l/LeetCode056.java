package l;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode056 {

    public static  int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals,(int[] t1, int[] t2)-> t1[0] ==t2[0]?0:t1[0]>t2[0]?1:-1 );

//        Arrays.sort(intervals,(int[] t1,int[] t2)->{ return t1[0]>t2[0]?1:-1;});
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int tmps = intervals[i][0];
            int tmpe = intervals[i][1];
            if (tmps >= start && tmps <= end) {
                if (tmpe >= end) {
                    end = tmpe;
                }
            } else if (tmps > end) {
                result.add(new int[]{start, end});
                start = tmps;
                end = tmpe;
            } else {
                start = tmps;
                if (tmpe >= end) {
                    end = tmpe;
                }
            }
        }
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);

    }
}
