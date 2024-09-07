package IsGraphBipartite785;

import java.util.ArrayDeque;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        var colors = new int[graph.length]; // Value 1 = Blue, 2 = Red
        for (var i = 0; i < graph.length; i++) {
            if (!this._bfs(graph, i, colors)) {
                return false;
            }
        }
        return true;
    }

    public boolean _bfs(int[][] graph, int i, int[] colors) {
        var queue = new ArrayDeque<Integer>();
        queue.add(i);
        if (colors[i] == 0) {
            colors[i] = 1; // Mark it as blue while starting
        }
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var j = 0; j < size; j++) {
                var parent = queue.poll();
                var parentColor = colors[parent];
                for (var edge : graph[parent]) {
                    var childColor = colors[edge];
                    if (childColor == 0) {
                        queue.add(edge);
                        colors[edge] = parentColor == 1 ? 2 : 1;
                    } else {
                        if (childColor == parentColor) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}