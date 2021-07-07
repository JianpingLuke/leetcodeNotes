import java.util.Arrays;

public class RemoveCoveredIntervals_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 1) return 1;
        Arrays.sort(intervals,(a,b)->{
            if (a[0] == b[0])
                return b[1] - a[1]; // 返回正数需要调整位置，负数则不需要
            return a[0] - b[0];
        });
        int l = intervals[0][0];
        int r = intervals[0][1];
        int res = 1;
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][1] <= r){
                continue;
            }else if(intervals[i][0] <= r){
                r = intervals[i][1];
                res++;
            } else {
                l = intervals[i][0];
                r = intervals[i][1];
                res++;
            }
        }
        return res;
    }
}
