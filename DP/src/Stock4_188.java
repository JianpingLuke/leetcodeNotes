public class Stock4_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 ) return 0;
        int[][][] dp = new int[prices.length][k+1][2];
        for (int mk = k; mk > 0; mk--) {
            dp[0][mk][0] = 0;
            dp[0][mk][1] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int mk = k; mk > 0; mk--) {
                dp[i][mk][0] = Math.max(dp[i-1][mk][0], dp[i-1][mk][1] + prices[i]);
                dp[i][mk][1] = Math.max(dp[i-1][mk][1], dp[i-1][mk-1][0] - prices[i]);
            }
        }
        int res = 0;
        for(int j=0; j<=k; j++){ // 格外注意，并不一定是交易满k次才是最优解（仅当k=2时这点恰好可以满足）
            res = Math.max(res,dp[prices.length-1][j][0]);
        }
        return res;
    }
}
