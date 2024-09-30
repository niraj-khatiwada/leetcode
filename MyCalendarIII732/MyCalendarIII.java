package MyCalendarIII732;

import java.util.TreeMap;

public class MyCalendarIII {
    public TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    public int max = 1;

    // O(n) where n is number of intervals. Technically it's O(2n) cause we have to
    // loop through all start and end points(number of stations)
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        var count = 0;
        for (var value : map.values()) {
            count += value;
            max = Math.max(max, count);
        }
        return max;
    }
}
