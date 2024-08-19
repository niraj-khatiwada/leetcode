package NQueens51;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rs = new ArrayList<>();
        var grid = new char[n][n];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        this._solveNQueens(grid, 0, rs);
        return rs;
    }

    private void _solveNQueens(char[][] grid, int i, List<List<String>> rs) {
        // Base Condition
        if (i >= grid.length) {
            printGrid(grid);
            // Add to list
            return;
        }

        for (var j = 0; j < grid.length; j++) {
            grid[i][j] = 'Q';
            _solveNQueens(grid, i + 1, rs);
            grid[i][j] = '.';
        }
    }

    private void printGrid(char[][] grid) {
        System.out.println("-----------");
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
