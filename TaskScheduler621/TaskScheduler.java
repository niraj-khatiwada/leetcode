package TaskScheduler621;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        var map = new HashMap<Character, Integer>();
        for (var ch : tasks) {
            var val = map.get(ch);
            map.put(ch, (val == null ? 0 : val) + 1);
        }
        var maxHeap = new PriorityQueue<Integer>(Comparator.comparingInt(x -> -x));
        for (var entry : map.entrySet()) {
            maxHeap.offer(entry.getValue());
        }
        var queue = new ArrayDeque<int[]>();
        var t = 0;
        while (true) {
            if (maxHeap.size() == 0 && queue.size() == 0)
                break;
            t++;
            var next = queue.peek();
            if (next != null && next[0] == t) {
                // Can be reused again
                queue.poll();
                if (next[1] > 0) {
                    maxHeap.offer(next[1]);
                }
            }
            if (maxHeap.size() == 0) {
                if (queue.size() == 0) {
                    // Complete
                    break;
                }
                // Idle
                continue;
            } else {
                var current = maxHeap.poll();
                if (current > 1) {
                    queue.offer(new int[] { t + n + 1, current - 1 });
                }
            }
        }
        return t;

    }
}
