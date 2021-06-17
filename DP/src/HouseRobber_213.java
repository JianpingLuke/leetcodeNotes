public class HouseRobber_213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[1], nums[0]);
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = dp1[0];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i]);
        }
        int max1 = dp1[nums.length - 2];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
        }
        int max2 = dp2[nums.length - 1];
        return Math.max(max1, max2);
    }

    public int so2(int[] nums) { // 将两种情况放在同一个求robber问题的函数中解决
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        return Math.max(best(nums, 0, n-2), best(nums, 1, n-1));
    }

    public int best(int[] nums, int start, int end) {
        if (end - start == 1) return Math.max(nums[start], nums[end]);
        int dp0 = nums[start], dp1 = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp = dp1;
            dp1 = Math.max(dp1, dp0 + nums[i]);
            dp0 = temp;
        }
        return dp1;
    }
}
