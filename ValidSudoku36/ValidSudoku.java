package ValidSudoku36;

import java.util.HashSet;

// Medium
public class ValidSudoku {

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
        while (x > 8) {
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