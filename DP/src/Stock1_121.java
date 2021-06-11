public class Stock1_121 {
    // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    // dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]) 错！ 之前应该没有买过不用算上dp
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int simple(int[] prices) {
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]); // 因为只买一次，所以dp1和dp0无关,用不上最优子结构
        }
        return dp0;
    }
}
