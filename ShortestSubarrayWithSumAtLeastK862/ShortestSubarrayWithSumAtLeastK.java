package ShortestSubarrayWithSumAtLeastK862;

import java.util.*;

public class ShortestSubarrayWithSumAtLeastK {
    // O(n)
    public int shortestSubarray(int[] nums, int k) {
        long min = Integer.MAX_VALUE;
        long sum = 0;
        var queue = new ArrayDeque<long[]>(); // sum, index
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k) {
                min = Math.min(min, i + 1);
            }
            // Compression
            while (!queue.isEmpty() && (sum - queue.peekFirst()[0]) >= k) {
                var c = queue.pollFirst();
                min = Math.min(min, i - c[1]);
            }
            // Maintain monotonically increasing order
            while (!queue.isEmpty() && sum <= queue.peekLast()[0]) {
                queue.pollLast();
            }
            queue.offer(new long[] { sum, i });
        }
        return min == (long) Integer.MAX_VALUE ? -1 : (int) min;
    }

}
