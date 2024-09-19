package MatrixDiagonalSum1572;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        var sum = 0;
        var p = 0;
        while (p < mat.length) {
            sum += mat[p][p];
            p++;
        }
        p = 0;
        while (p < mat.length) {
            sum += mat[p][mat.length - p - 1];
            p++;
        }
        if (mat.length % 2 != 0) {
            sum -= mat[mat.length / 2][mat.length / 2];
        }
        return sum;
    }
}
