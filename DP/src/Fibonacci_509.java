public class Fibonacci_509 {
    public int fib(int n) {
        int dp0 = 0, dp1 = 1;
        if (n == 0) return dp0;
        if (n == 1) return dp1;
        for (int i = 2; i <= n; i++) {
            int temp = dp1;
            dp1 = dp0 + dp1;
            dp0 = temp;
        }
        return dp1;
    }
}
