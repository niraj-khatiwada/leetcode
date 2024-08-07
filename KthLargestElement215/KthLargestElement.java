package KthLargestElement215;

import java.util.PriorityQueue;

public class KthLargestElement {
    // Instead of adding all n values to the heap and removing k times to get the
    // kth largest value, if we maintain min heap size = k, we'll get more optimized
    // solution. The earlier one takes n(log(n)). The below one takes n(log(k))

    // n(log(k))
    public int findKthLargest(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>();
        for (var n : nums) {
            if (minHeap.size() >= k) {
                if (n > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            } else {
                minHeap.offer(n);
            }
        }
        return minHeap.peek();
    }
}
