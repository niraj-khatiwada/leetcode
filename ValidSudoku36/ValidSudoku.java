package ValidSudoku36;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Medium
public class ValidSudoku {

    // Using HashMap Method
    // O(n^2). Only looped once. Highly efficient
    // But this takes extra spaces for 3 hash maps
    public boolean isValidSudokuUsingHashMapMethod(char[][] board) {
        Map<String, Set<Character>> rowMap = new HashMap<>();
        Map<String, Set<Character>> columnMap = new HashMap<>();
        Map<String, Set<Character>> gridMap = new HashMap<>();

        for (var i = 0; i < 9; i++) {
            for (var j = 0; j < 9; j++) {
                var value = board[i][j];
                if (value == '.') {
                    continue;
                }
                // Rows
                var rowKey = String.format("%s", i);
                var rowSet = rowMap.get(rowKey) == null ? new HashSet<Character>() : rowMap.get(rowKey);
                if (!rowSet.add(value)) {
                    return false;
                }
                rowMap.put(rowKey, rowSet);

                // Columns
                var columnKey = String.format("%s", j);
                var columnSet = columnMap.get(columnKey) == null ? new HashSet<Character>()
                        : columnMap.get(columnKey);
                if (!columnSet.add(value)) {
                    return false;
                }
                columnMap.put(columnKey, columnSet);

                // Grid
                // We interpolate the higher matrix into smaller one
                var gridKey = String.format("%s|%s", (i / 3), (j / 3));
                var gridSet = gridMap.get(gridKey) == null ? new HashSet<Character>() : gridMap.get(gridKey);
                if (!gridSet.add(value)) {
                    return false;
                }
                gridMap.put(gridKey, gridSet);
            }
        }
        return true;
    }

    // O(n^2) * 3 ~ O(n^2)
    // You need to do nested operation three times so less efficient
    // No extra spaces is allocated though
    public boolean isValidSudoku(char[][] board) {
        // Rows
        for (var i = 0; i < 9; i++) {
            var set = new HashSet<Character>();
            for (var j = 0; j < 9; j++) {
                var value = board[i][j];
                if (value != '.') {
                    var isNew = set.add(value);
                    if (!isNew) {
                        return false;
                    }
                }
            }
        }
        // Columns
        for (var i = 0; i < 9; i++) {
            var set = new HashSet<Character>();
            for (var j = 0; j < 9; j++) {
                var value = board[j][i];
                if (value != '.') {
                    var isNew = set.add(value);
                    if (!isNew) {
                        return false;
                    }
                }
            }
        }
        // Sub-grid
        var x = 0;
        var y = 0;
        while (x < 9) {
            var set = new HashSet<Character>();
            for (var i = x; i < (x + 3); i++) {
                for (var j = y; j < (y + 3); j++) {
                    var value = board[i][j];
                    if (value != '.') {
                        var isNew = set.add(value);
                        if (!isNew) {
                            return false;
                        }
                    }
                }
            }
            y += 3;
            if (y > 8) {
                x += 3;
                y = 0;
            }
        }
        return true;
    }

}

// var sudoku = new ValidSudoku();

// char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
// { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
// { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
// { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
// { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
// { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
// { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
// { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
// { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

// System.out.println(sudoku.isValidSudoku(board));