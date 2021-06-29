public class Stock6_714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];//
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int so2(int[] prices, int fee) {
        int dp00 = 0;
        int dp01 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp00 = Math.max(dp00, dp01 + prices[i] - fee);
            dp01 = Math.max(dp01, dp00 - prices[i]);
        }
        return dp00;
    }
}
// 类似于这种[i] = f([i-1]) || f([i]) 的dp，都可以转化成space = 1的运算。