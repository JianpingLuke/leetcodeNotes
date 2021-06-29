import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[i] >= temperatures[s.peek()]) s.pop(); // 注意这里可以等于,因为等于也覆盖了
            res[i] = s.isEmpty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return res;
    }

    public int[] so2(int[] T) {
        int n = T.length;
        int[] res =  new int[n];
        res[n-1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (T[i] < T[i-1]) res[i] = 1;
            else {
                int j = i + 1;
                while (j < n && T[i] >= T[j] && res[j] != 0) j = j + res[j]; // 这里类似于dp了
                if (j < n && T[i] < T[j]) res[i] = j - i; // while可能会直接跳过，所以大小要重新判断
                else res[i] = 0;
            }
        }
        return res;
    }
}
