import ValidSudoku36.ValidSudoku;

public class Main {
    public static void main(String[] args) {

        var sudoku = new ValidSudoku();

        char[][] board = { { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '.', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        System.out.println(sudoku.isValidSudokuUsingHashMapMethod(board));
    }

}
