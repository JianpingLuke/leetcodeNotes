import java.util.Arrays;
import java.util.LinkedList;

public class Merge_Intervals_56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //比较器的使用
            LinkedList<int[]> listRes = new LinkedList<>(); //LinkedList的使用，应对不定长数组
            int[] singleInte = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                if (singleInte[1] <= intervals[i][0]) {
                    singleInte[1] = Math.max(singleInte[1], intervals[i][1]);
                }else {
                    listRes.add(singleInte);
                    singleInte = intervals[i];
                }
            }
            if (singleInte != null) listRes.add(singleInte);
            return listRes.toArray(new int[listRes.size()][]); // Linkedlist转为数组
        }
    }
    class Solution2 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            LinkedList<int[]> merged = new LinkedList<>();
            for (int[] interval : intervals) {
                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                    merged.add(interval);
                }else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]); // 直接在Linkedlist上修改，省去了先确定再加入的步骤
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
