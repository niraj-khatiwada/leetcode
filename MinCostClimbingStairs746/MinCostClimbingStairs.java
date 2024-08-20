package MinCostClimbingStairs746;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        var dp = new int[cost.length + 1];
        return Math.min(this._minCostClimbingStairs(cost, 0, 0, dp),
                this._minCostClimbingStairs(cost, 1, 0, dp));
    }

    private int _minCostClimbingStairs(int[] cost, int i, int v, int[] dp) {
        if (i >= cost.length) {
            return v;
        }

        v += cost[i];
        if (dp[i] != 0) {
            return v + dp[i];
        }
        var min = Math.min(_minCostClimbingStairs(cost, i + 1, v, dp), _minCostClimbingStairs(cost, i + 2, v, dp));
        dp[i] = min - v;
        return min;
    }
}