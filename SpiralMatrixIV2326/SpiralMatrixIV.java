package SpiralMatrixIV2326;

public class SpiralMatrixIV {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        var matrix = new int[m][n];
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        if (head == null) {
            return matrix;
        }
        var dir = new int[] { 0, 1 }; // (0,1) = right; (1, 0) = bottom; (0, -1) = left; (-1, 0) = up
        var coord = new int[] { 0, -1 };
        var current = head;
        while (current != null) {
            var changeDirCount = 0;
            var next = new int[] { coord[0] + dir[0], coord[1] + dir[1] };
            if (this._canMove(matrix, next)) {
                changeDirCount = 0;
                coord[0] = next[0];
                coord[1] = next[1];
                matrix[coord[0]][coord[1]] = current.val;
                current = current.next;
            } else {
                _changeDirection(dir);
                changeDirCount++;
            }
            // Deadend
            if (changeDirCount == 4) {
                break;
            }
        }
        return matrix;
    }

    private boolean _canMove(int[][] matrix, int[] coord) {
        var m = matrix.length;
        var n = matrix[0].length;
        var i = coord[0];
        var j = coord[1];
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] != -1) {
            return false;
        }
        return true;
    }

    private int[] _changeDirection(int[] dir) {
        if (dir[0] == 0 && dir[1] == 1) {
            dir[0] = 1;
            dir[1] = 0;
            return dir;
        } else if (dir[0] == 1 && dir[1] == 0) {
            dir[0] = 0;
            dir[1] = -1;
            return dir;
        } else if (dir[0] == 0 && dir[1] == -1) {
            dir[0] = -1;
            dir[1] = 0;
            return dir;
        }
        dir[0] = 0;
        dir[1] = 1;
        return dir;
    }
}