package ClimbingStairs70;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return this._climbStairs(n, new int[n + 1]);
    }

    private int _climbStairs(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = _climbStairs(n - 1, dp) + _climbStairs(n - 2, dp);
        return dp[n];
    }
}
