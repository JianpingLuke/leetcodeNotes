public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) { //注意楼梯有bottom和top不算一个step
        int dp0 = cost[0];
        int dp1 = cost[1]; // 直接跨到第二层
        for (int i = 2; i < cost.length; i++) {
            int temp = dp1;
            dp1 = Math.min(dp1 + cost[i], dp0 + cost[i]);
            dp0 = temp;
        }
        return Math.min(dp0, dp1);
    }
}
