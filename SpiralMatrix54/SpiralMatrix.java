package SpiralMatrix54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        var rs = new ArrayList<Integer>();
        var coord = new int[] { 0, -1 };
        var dir = new int[] { 0, 1 };
        var dirCount = 0;
        while (true) {
            if (this._isValid(matrix, coord[0] + dir[0], coord[1] + dir[1])) {
                dirCount = 0;
                coord[0] = coord[0] + dir[0];
                coord[1] = coord[1] + dir[1];
                rs.add(matrix[coord[0]][coord[1]]);
                matrix[coord[0]][coord[1]] = Integer.MAX_VALUE;
            } else {
                this._changeDir(dir);
                dirCount++;
            }
            if (dirCount >= 4) {
                break;
            }
        }
        return rs;
    }

    private boolean _isValid(int[][] matrix, int i, int j) {
        return !(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == Integer.MAX_VALUE);
    }

    private void _changeDir(int[] dir) {
        if (dir[0] == 0 && dir[1] == 1) {
            dir[0] = 1;
            dir[1] = 0;
        } else if (dir[0] == 1 && dir[1] == 0) {
            dir[0] = 0;
            dir[1] = -1;
        } else if (dir[0] == 0 && dir[1] == -1) {
            dir[0] = -1;
            dir[1] = 0;
        } else {
            dir[0] = 0;
            dir[1] = 1;
        }
    }

}
