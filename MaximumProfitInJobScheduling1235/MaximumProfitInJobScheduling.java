package MaximumProfitInJobScheduling1235;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        var matrix = new int[startTime.length][3];
        for (var i = 0; i < matrix.length; i++) {
            matrix[i][0] = startTime[i];
            matrix[i][1] = endTime[i];
            matrix[i][2] = profit[i];
        }
        Arrays.sort(matrix, (a, b) -> a[0] - b[0]);
        var dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        return this._jobScheduling(matrix, 0, dp);
    }

    private int _jobScheduling(int[][] matrix, int i, int[] dp) {
        if (i >= matrix.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        var j = _search(matrix, i);
        var included = 0;
        if (j != -1) {
            included = matrix[i][2] + _jobScheduling(matrix, j, dp);
        }
        var excluded = _jobScheduling(matrix, i + 1, dp);
        var max = Math.max(included, excluded);
        dp[i] = max;
        return max;
    }

    private int _search(int[][] matrix, int i) {
        var l = i + 1;
        var r = matrix.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] >= matrix[i][1]) {
                r = m;
            } else {
                l = m + 1;
            }
            if (l == r) {
                return r;
            }
        }
        return -1;
    }
}