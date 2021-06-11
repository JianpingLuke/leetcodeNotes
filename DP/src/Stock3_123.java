public class Stock3_123 {
    public int maxProfit(int[] prices){
        int[][][] dp = new int[prices.length][3][2];
        // 初始值要根据状态转移方程来定
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        // k表示进行了几次交易，其中k=0的情况虽有，但对后面没影响
        // 很容易发现，k=0 所有取值都为0，那么既然已知，就没必要花这个时间去为它赋值
        // 而k = 1 的情况其实是从k = 0的情况转移而来，所以我们为它赋个初始值就行了
        // 但如果放在循环中，就会使代码复杂好多
        for (int i = 1; i < prices.length; i++) {
            for (int k = 2; k > 0; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][0], dp[i-1][k-1][0] - prices[i]); // 可以发现dp[n][2][1]可以一直传递，直到出现更优的最优子结构
                // 故初始值设为第一天的价格，后面遇到更优的再变
            }
        }
        return dp[prices.length-1][2][0];
    }
}
