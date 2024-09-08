package MinimumCostToConnectAllPoints1584;

import java.util.*;

public class MinimumCostToConnectAllPoints {
    // O(v^2 * log(v))
    public int minCostConnectPoints(int[][] points) {
        var cost = 0;
        var visited = new HashSet<Integer>();
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[1]));
        queue.offer(new int[] { 0, 0 });
        while (visited.size() != points.length) {
            var current = queue.poll();
            var i = current[0];
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            cost += current[1];
            for (var j = 0; j < points.length; j++) {
                if (i != j || !visited.contains(j)) {
                    var distance = Math.abs(points[j][1] - points[i][1]) + Math.abs(points[j][0] - points[i][0]);
                    queue.offer(new int[] { j, distance });
                }
            }
        }
        return cost;
    }

}
