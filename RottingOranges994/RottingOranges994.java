package RottingOranges994;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.TreeSet;

public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {
        var fc = 0;
        var rl = grid.length;
        var cl = grid[0].length;
        var queue = new ArrayDeque<int[]>();
        for (var i = 0; i < rl; i++) {
            for (var j = 0; j < cl; j++) {
                if (grid[i][j] == 1) {
                    fc++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                }
            }
        }
        if (fc == 0) {
            return 0;
        }
        var time = 0;
        var visited = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        while (!queue.isEmpty()) {
            var size = queue.size();
            var rotted = false;
            for (var x = 0; x < size; x++) {
                var coord = queue.poll();
                if (coord[0] < 0 || coord[0] >= rl || coord[1] < 0 || coord[1] >= cl || grid[coord[0]][coord[1]] == 0
                        || visited.contains(coord)) {
                    continue;
                }
                visited.add(coord);
                if (grid[coord[0]][coord[1]] == 1) {
                    fc--;
                    if (!rotted) {
                        rotted = true;
                    }
                }
                var c = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
                for (var p : c) {
                    queue.add(new int[] { coord[0] + p[0], coord[1] + p[1] });
                }
            }
            if (rotted) {
                time++;
            }
        }
        return fc == 0 ? time : -1;
    }
}
