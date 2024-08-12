package IslandsAndTreasures;

import java.util.*;

public class IslandAndTreasures {
    public void islandsAndTreasure(int[][] grid) {
        var rlen = grid.length;
        var clen = grid[0].length;
        for (var i = 0; i < rlen; i++) {
            for (var j = 0; j < clen; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    var rs = new int[] { Integer.MAX_VALUE };
                    var visited = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
                    var queue = new ArrayDeque<int[]>();
                    queue.add(new int[] { i, j });
                    var d = 0;
                    while (!queue.isEmpty()) {
                        var size = queue.size();
                        for (var x = 0; x < size; x++) {
                            var coord = queue.poll();
                            if (coord[0] < 0 || coord[0] >= rlen || coord[1] < 0 || coord[1] >= clen
                                    || grid[coord[0]][coord[1]] == -1 || visited.contains(coord)) {
                                continue;
                            }
                            if (grid[coord[0]][coord[1]] == 0) {
                                rs[0] = d;
                                break;
                            }
                            visited.add(coord);
                            var neighbors = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
                            for (var n : neighbors) {
                                queue.add(new int[] { coord[0] + n[0], coord[1] + n[1] });
                            }
                        }
                        if (rs[0] != Integer.MAX_VALUE) {
                            break;
                        }
                        d++;
                    }
                    grid[i][j] = rs[0];
                }
            }
        }
    }
}
