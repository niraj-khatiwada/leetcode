package SearchA2DMatrix74;

public class SearchA2DMatrix {
    // O(n*m)
    // SC: O(n*m)
    public boolean searchMatrix(int[][] matrix, int target) {
        var flatten = new int[matrix.length * matrix[0].length];
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                var ij = i * matrix[0].length + j;
                flatten[ij] = matrix[i][j];
            }
        }
        return _binarySearch(flatten, target);
    }

    private boolean _binarySearch(int[] array, int target) {
        var l = 0;
        var r = array.length - 1;
        while (l <= r) {
            var m = (r + l) / 2;
            if (array[m] == target) {
                return true;
            } else if (target < array[m]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
