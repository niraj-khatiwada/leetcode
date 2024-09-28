package MyCalendarII731;

import java.util.*;

public class MyCalendarII {
    public List<int[]> events = new ArrayList<>();
    public List<int[]> overlap = new ArrayList<>();

    // O(n^2)
    public boolean book(int start, int end) {
        for (var lap : overlap) {
            if (Math.max(start, lap[0]) < Math.min(end, lap[1])) {
                return false;
            }
        }
        for (var lap : events) {
            if (Math.max(start, lap[0]) < Math.min(end, lap[1])) {
                overlap.add(new int[] { Math.max(start, lap[0]), Math.min(end, lap[1]) });
            }
        }
        events.add(new int[] { start, end });
        return true;
    }

    // Line Sweep Algorithm
    public TreeMap<Integer, Integer> map = new TreeMap<>();

    public boolean bookLineSweep(int start, int end) {
        var s = map.get(start);
        var e = map.get(end);
        map.put(start, (s == null ? 0 : s) + 1);
        map.put(end, (e == null ? 0 : e) - 1);

        var count = 0;
        for (var entry : map.entrySet()) {
            count += entry.getValue();
            if (count > 2) {
                // Revert
                if (s == null) {
                    map.remove(start);
                } else {
                    map.put(start, s);
                }
                if (e == null) {
                    map.remove(end);
                } else {
                    map.put(end, e);
                }
                return false;
            }
        }
        return true;
    }
}
