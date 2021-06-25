public class PartitionEqual_416 {
    public boolean canPartition(int[] nums) {
        if (nums.length == 1) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i < nums.length+1; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i-1][j] || (j-nums[i-1] >= 0) && dp[i-1][j-nums[i-1]]; // 巧妙的写法
            }
        }
        return dp[nums.length][target];
    }
}