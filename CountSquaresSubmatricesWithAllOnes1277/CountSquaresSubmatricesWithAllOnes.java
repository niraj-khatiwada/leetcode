package CountSquaresSubmatricesWithAllOnes1277;

import java.util.ArrayDeque;

public class CountSquaresSubmatricesWithAllOnes {
    public int countSquares(int[][] matrix) {
        var num = 0;
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    var queue = new ArrayDeque<int[]>();
                    queue.offer(new int[] { i, j });
                    var level = 0;
                    while (!queue.isEmpty()) {
                        var size = queue.size();
                        var isValid = true;
                        int[] coord = queue.peek();
                        for (var k = 0; k < size; k++) {
                            var curr = queue.poll();
                            if (curr[0] >= matrix.length || curr[1] >= matrix[0].length || matrix[curr[0]][curr[1]] != 1
                                    || !this._reverseBfs(matrix, i, j, level)) {
                                isValid = false;
                                break;
                            }
                            queue.offer(new int[] { curr[0], curr[1] + 1 });
                            queue.offer(new int[] { curr[0] + 1, curr[1] });
                        }
                        if (isValid) {
                            num++;
                        } else {
                            break;
                        }
                        level++;
                    }
                }
            }
        }
        return num;
    }

    private boolean _reverseBfs(int[][] matrix, int i, int j, int level) {
        var queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { i + level, j + level });
        var _level = 0;
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var k = 0; k < size; k++) {
                var curr = queue.poll();
                if (curr[0] >= matrix.length || curr[1] >= matrix[0].length || matrix[curr[0]][curr[1]] != 1) {
                    return false;
                }
                queue.offer(new int[] { curr[0], curr[1] - 1 });
                queue.offer(new int[] { curr[0] - 1, curr[1] });
            }
            _level++;
            if (_level >= level) {
                return true;
            }
        }
        return false;
    }
}
