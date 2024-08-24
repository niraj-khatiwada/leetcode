package NonOverlappingIntervals435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[1]));
        var count = 1;
        var lastIndex = 0;
        for (var i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[lastIndex][1]) {
                count++;
                lastIndex = i;
            }
        }
        return intervals.length - count;
    }
}