package MaxAreaOfAnIsland695;

public class MaxAreaOfAnIsland {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            var maxArea = 0;
            var rl = grid.length;
            var cl = grid[0].length;
            for (var i = 0; i < rl; i++) {
                for (var j = 0; j < cl; j++) {
                    if (grid[i][j] == 1) {
                        var rs = new int[] { 0 };
                        this._dfs(i, j, grid, rs);
                        maxArea = Math.max(maxArea, rs[0]);
                    }
                }
            }
            return maxArea;
        }

        private void _dfs(int x, int y, int[][] grid, int[] rs) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
                return;
            }
            rs[0]++;
            grid[x][y] = 0;
            _dfs(x, y + 1, grid, rs);
            _dfs(x + 1, y, grid, rs);
            _dfs(x, y - 1, grid, rs);
            _dfs(x - 1, y, grid, rs);
        }
    }
}
