public class ClimbingStairs_70 {
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) return n;
            int[] dp = new int[n];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) { // 从未定义的开始，不然会覆盖！
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }
}
