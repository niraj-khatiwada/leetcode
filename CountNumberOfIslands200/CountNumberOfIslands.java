package CountNumberOfIslands200;

public class CountNumberOfIslands {
    public int numIslands(char[][] grid) {
        var c = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[i].length; j++) {
                var item = grid[i][j];
                if (item == '1') {
                    c++;
                    this.visit(i, j, grid);
                }
            }
        }
        return c;
    }

    private void visit(int x, int y, char[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        visit(x, y + 1, grid);
        visit(x + 1, y, grid);
        visit(x, y - 1, grid);
        visit(x - 1, y, grid);
    }
}
