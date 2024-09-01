package MeetingSchedule920;

import java.util.Arrays;
import java.util.List;

public class MeetingSchedule {

    public class Interval {

        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        var matrix = new int[intervals.size()][2];
        for (var i = 0; i < matrix.length; i++) {
            var interval = intervals.get(i);
            matrix[i] = new int[] { interval.start, interval.end };
        }
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        var lastEnd = 0;
        for (var item : matrix) {
            if (item[0] < lastEnd) {
                return false;
            }
            lastEnd = item[1];
        }
        return true;
    }
}
