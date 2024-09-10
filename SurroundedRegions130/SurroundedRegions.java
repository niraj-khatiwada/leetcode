package SurroundedRegions130;

public class SurroundedRegions {
    // O(n*m)
    public void solve(char[][] board) {
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if ((i == 0 || j == 0 || i == (board.length - 1) || j == (board[0].length - 1)) && board[i][j] == 'O') {
                    this._dfs(board, i, j);
                }
            }
        }
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void _dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '.';
        var dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        for (var dir : dirs) {
            this._dfs(board, i + dir[0], j + dir[1]);
        }
    }
}