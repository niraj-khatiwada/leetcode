package WordSearch79;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class WordSearch {
    // O(n * m * dfs);
    // dfs = 4 ^ (length of word)
    // So, ~ (n * m * 4 ^ (len(word)))
    public boolean exist(char[][] board, String word) {
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    var set = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
                    if (this._dfs(board, word, 0, i, j, set)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean _dfs(char[][] board, String word, int i, int x, int y, Set<int[]> visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited.contains(new int[] { x, y })) {
            return false;
        }

        if (i >= word.length()) {
            return true;
        } else {
            if (board[x][y] != word.charAt(i)) {
                return false;
            }
        }

        var coord = new int[] { x, y };
        visited.add(coord);

        var dx = new int[] { -1, 0, 1, 0 };
        var dy = new int[] { 0, 1, 0, -1 };

        for (var j = 0; j < 4; j++) {
            if (_dfs(board, word, i + 1, x + dx[j], y + dy[j], visited)) {
                return true;
            }
        }

        visited.remove(coord);

        return false;
    }
}
