package PacificAtlanticWaterflow417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PacificAtlanticWaterflow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        var rlen = heights.length;
        var clen = heights[0].length;
        var pacific = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        var atlantic = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        for (var row = 0; row < rlen; row++) {
            this._dfs(row, 0, heights, 0, pacific);
            this._dfs(row, clen - 1, heights, 0, atlantic);
        }
        for (var col = 0; col < clen; col++) {
            this._dfs(0, col, heights, 0, pacific);
            this._dfs(rlen - 1, col, heights, 0, atlantic);
        }
        for (var s : pacific) {
            if (atlantic.contains(s)) {
                var list = new ArrayList<Integer>();
                list.add(s[0]);
                list.add(s[1]);
                result.add(list);
            }
        }
        return result;
    }

    private void _dfs(int x, int y, int[][] grid, int ph, Set<int[]> visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited.contains(new int[] { x, y })
                || grid[x][y] < ph) {
            return;
        }
        visited.add(new int[] { x, y });
        var h = grid[x][y];
        _dfs(x, y + 1, grid, h, visited);
        _dfs(x + 1, y, grid, h, visited);
        _dfs(x, y - 1, grid, h, visited);
        _dfs(x - 1, y, grid, h, visited);
    }
}
