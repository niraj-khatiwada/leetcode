package Convert1DArrayTo2DArray2022;

public class Convery1DArrayTo2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        var matrix = new int[m][n];
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                var flat = i * n + j;
                matrix[i][j] = original[flat];
            }
        }
        return matrix;
    }
}
