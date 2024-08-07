package KClosestPointsToOrigin973;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    private class Node {
        public int distance;
        public int[] value;

        public Node(int distance, int[] value) {
            this.distance = distance;
            this.value = value;
        }
    }

    // nlog(k) -> More efficient
    public int[][] kClosest(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }
        var maxHeap = new PriorityQueue<Node>(Comparator.comparingInt(x -> -(x.distance)));
        for (var p : points) {
            int distance = p[0] * p[0] + p[1] * p[1];
            if (maxHeap.size() >= k) {
                if (distance < maxHeap.peek().distance) {
                    maxHeap.poll(); // log(k)
                    maxHeap.offer(new Node(distance, p)); // log(k)
                }
            } else {
                maxHeap.offer(new Node(distance, p));
            }
        }
        int[][] rs = new int[k][2];
        for (var i = 0; i < rs.length; i++) {
            rs[i] = maxHeap.poll().value;
        }
        return rs;
    }

    // n(log(n))
    public int[][] kClosestMethod2(int[][] points, int k) {
        if (k == points.length) {
            return points;
        }
        var minHeap = new PriorityQueue<Node>(Comparator.comparingInt(x -> (x.distance)));
        // nlog(n)
        for (var p : points) {
            int distance = p[0] * p[0] + p[1] * p[1];
            minHeap.offer(new Node(distance, p)); // log(n)
        }
        int[][] rs = new int[k][2];
        for (var i = 0; i < rs.length; i++) {
            var node = minHeap.poll();
            if (node != null) {
                rs[i] = node.value;
            }
        }
        return rs;
    }
}
