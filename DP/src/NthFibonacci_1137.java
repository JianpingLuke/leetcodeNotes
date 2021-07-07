public class NthFibonacci_1137 {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if (n == 0) return t0;
        if (n <= 2) return 1;
        for (int i = 3; i <= n; i++) {
            int temp0 = t1;
            int temp1 = t2;
            t2 = t0 + t1 + t2; //其实只有t2赋值了，所以只需一个temp就够了
            t0 = temp0;
            t1 = temp1;
        }
        return t2;
    }
}
