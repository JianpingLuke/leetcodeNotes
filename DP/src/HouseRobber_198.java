public class HouseRobber_198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (nums.length == 2) return dp[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    //可见只有两个变量往前递增，故可以再简化
    public int rob2(int[] nums) {
        int dp0 = nums[0];
        if (nums.length == 1) return dp0;
        int dp1 = Math.max(nums[0], nums[1]);
        //if (nums.length == 2) return dp1; //---可和下一步合并，不用判断
        for (int i = 2; i < nums.length; i++) {
            dp1 = Math.max(dp1, dp0 + nums[i]);
        }
        return dp1;
    }
}
