package RankTransformOfAnArray1331;

import java.util.Arrays;

public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        var matrix = new int[arr.length][2];
        // O(n)
        for (var i = 0; i < arr.length; i++) {
            matrix[i][0] = arr[i];
            matrix[i][1] = i;
        }
        // O(nlog(n))
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        var rank = 0;
        var last = Integer.MAX_VALUE;
        // O(n)
        for (var item : matrix) {
            if (rank == 0 || item[0] != last) {
                rank++;
            }
            arr[item[1]] = rank;
            last = item[0];
        }
        return arr;
    }
}