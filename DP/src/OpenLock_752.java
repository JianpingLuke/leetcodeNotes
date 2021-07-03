import java.util.*;

public class OpenLock_752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String d : deadends) deads.add(d);
        int step = 0;
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String temp = q.poll();
                if (deads.contains(temp)) continue;
                if (temp.equals(target)) return step;
                for (int j = 0; j < 4; j++) { // 每一步的情况遍历下来
                    String up = turnUp(j, temp);
                    if (!visited.contains(up)) {
                        q.add(up);
                        visited.add(up);
                    }
                    String down = turnDown(j, temp);
                    if (!visited.contains(down)) {
                        q.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String turnDown(int j, String temp) { // 注意这里对String和char的掌控
        char[] a = temp.toCharArray();
        if (a[j] == '0') a[j] = '9';
        else a[j]--; // 注意这里可以直接对char加减，数字自然会减1
        return new String(a);
    }

    private String turnUp(int j, String temp) {
        char[] a = temp.toCharArray();
        if (a[j] == '9') a[j] = '0';
        else a[j]++;
        return new String(a);
    }

}
