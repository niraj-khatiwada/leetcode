package BestTimeToBuyAndSellStock121;

public class BestTimeToBuyAndSellStock {
    // O(n)
    public int maxProfit(int[] prices) {
        var l = 0;
        var r = 1;
        var max = 0;
        while (r < prices.length) {
            var p = prices[r] - prices[l];
            if (p > max) {
                max = p;
            }
            if (prices[r] < prices[l]) {
                l = r;
            }
            r++;
        }
        return max;
    }
}
