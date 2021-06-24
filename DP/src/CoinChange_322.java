public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        final int INF = amount + 1;
        int[] dp = new int[INF];
        for (int i = 0; i <= amount; i++) dp[i] = INF;
        dp[0] = 0;
        for (int coin : coins) {
            if (coin > amount) continue;
            dp[coin] = 1;
        }
        for (int amt = 1; amt <= amount; amt++) {
            for (int coin : coins) {
                if (coin >= amount) continue;
                dp[amount] = Math.min(dp[amt], dp[amt - coin] + 1); // 如果change多次，则肯定会有多次的间隔
            }
        }
        return dp[amount] >= INF ? -1 : dp[amount];
    }
}
