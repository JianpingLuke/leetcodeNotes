import java.util.ArrayList;
import java.util.List;

public class N_Queen_51 {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) { // 回溯法
        List<String> l = new ArrayList<>();
        traveQueen(l, n);
        return res;
    }

    public void traveQueen(List<String> l, int n) {
        if (l.size() == n) {
            List<String> l1 = new ArrayList<>(l);
            res.add(l1);
            return;
        }
        for (int i = 0; i < n; i++) { // 对一行遍历，每列设为'Q'试试
            boolean flag = checkLeagal(l, n, i);
            if (flag) {
                char[] ctemp = new char[n];
                for (int j = 0; j < n; j++) { // 这里不是遍历，仅仅是把一行都初始化为'.'
                    ctemp[j] = '.';
                }
                ctemp[i] = 'Q';
                String temp = new String(ctemp);
                l.add(temp);
                traveQueen(l, n);
                l.remove(l.size() - 1);
            }
        }
    }

    public boolean checkLeagal(List<String> l, int n, int index) {
        if (l.size() < 1) return true;
        for (int i = l.size() - 1; i>=0; i--) {
            if (l.get(i).charAt(index) == 'Q') return false;
        }
        int a = index;
        for (int i = l.size() - 1; i>=0; i--) {
            if (a+1 > n-1) break;
            if (l.get(i).charAt(a+1) == 'Q') return false;
            a++;
        }
        int b = index;
        for (int i = l.size() - 1; i>=0; i--) {
            if (b-1 < 0) return false;
            if (l.get(i).charAt(b-1) == 'Q') return false;
            b--;
        }
        return true;
    }
    
}
