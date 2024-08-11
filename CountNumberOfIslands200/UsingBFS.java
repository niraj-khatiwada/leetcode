package CountNumberOfIslands200;

import java.util.*;

public class UsingBFS {
    public int numIslands(char[][] grid) {
        var c = 0;
        var visited = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        var rl = grid.length;
        var cl = grid[0].length;
        for (var i = 0; i < rl; i++) {
            for (var j = 0; j < cl; j++) {
                if (grid[i][j] == '1' && !visited.contains(new int[] { i, j })) {
                    var queue = new ArrayDeque<int[]>(); // You can replace this with Stack to use DFS instead
                    queue.add(new int[] { i, j });
                    while (!queue.isEmpty()) {
                        var coord = queue.poll();
                        var x = coord[0];
                        var y = coord[1];
                        if (visited.contains(coord) || !(x >= 0 && x < rl)
                                || !(y >= 0 && y < cl) || grid[x][y] == '0') {
                            continue;
                        }
                        System.out.printf("%s %s\n", x, y);
                        visited.add(coord);
                        queue.add(new int[] { x, y + 1 });
                        queue.add(new int[] { x + 1, y });
                        queue.add(new int[] { x, y - 1 });
                        queue.add(new int[] { x - 1, y });
                    }
                    c++;
                }
            }

        }
        return c;
    }
}
