package ValidSudoku36;

import java.util.HashSet;
import java.util.Set;


public class Main {


    public static void main(String[] args) {
//        char[][] board = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'}, {'.', '4', '.', '3', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '3', '.', '.', '1'}, {'8', '.', '.', '.', '.', '.', '.', '2', '.'}, {'.', '.', '2', '.', '7', '.', '.', '.', '.'}, {'.', '1', '5', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '2', '.', '.', '.'}, {'.', '2', '.', '9', '.', '.', '.', '.', '.'}, {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> setRow = new HashSet<>();
            Set<Integer> setColumn = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                var rowValue = board[i][j];
                if (rowValue != '.') {
                    var rowNumValue = Integer.parseInt(String.valueOf(rowValue));
                    if (rowNumValue < 1 || rowNumValue > 9) {
                        return false;
                    }
                    if (setRow.contains(rowNumValue)) {
                        return false;
                    }
                    setRow.add(rowNumValue);
                }
                var columnValue = board[j][i];
                if (columnValue != '.') {
                    var columnNumValue = Integer.parseInt(String.valueOf(columnValue));
                    if (columnNumValue < 1 || columnNumValue > 9) {
                        return false;
                    }
                    if (setColumn.contains(columnNumValue)) {
                        return false;
                    }
                    setColumn.add(columnNumValue);
                }
            }
        }
        for (int i = 3; i <= 9; i += 3) {
            for (int j = 3; j <= 9; j += 3) {
                Set<Integer> set = new HashSet<>();
                for (int ii = i - 3; ii < i; ii++) {
                    for (int jj = j - 3; jj < j; jj++) {
                        var value = board[ii][jj];
                        if (value != '.') {
                            var numValue = Integer.parseInt(String.valueOf(value));
                            if (numValue < 1 || numValue > 9) {
                                return false;
                            }
                            if (set.contains(numValue)) {
                                return false;
                            }
                            set.add(numValue);
                        }
                    }
                }
            }
        }
        return true;
    }

}