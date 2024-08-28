package CoinChange322;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        var dp = new int[amount + 1];
        for (var i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (var a = 1; a <= amount; a++) {
            for (var c : coins) {
                if (c <= a) {
                    dp[a] = Math.min(dp[a], (1 + dp[a - c]));
                }
            }
        }
        return dp[amount] < (amount + 1) ? dp[amount] : -1;
    }

}