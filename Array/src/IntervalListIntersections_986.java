import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class IntervalListIntersections_986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        int ai = 0;
        int bi = 0;
        while (ai < firstList.length && bi < secondList.length) { // 注意ai，bi的更新，不一定赋值后就更新，可能a驻留对应好几个b
            int[] a = firstList[ai];
            int[] b = secondList[bi];
            if (b[0] <= a[0]) {
                if (b[1] < a[0]) {
                    bi++;
                }else if (b[1] == a[0]) {
                    res.add(new int[]{a[0],a[0]});
                    bi++;
                }else {
                    if (b[1] <= a[1]) {
                        res.add(new int[]{a[0],b[1]});
                        bi++;
                    }else {
                        res.add(new int[]{a[0],a[1]});
                        ai++;
                    }
                }
            }else if (b[0] <= a[1]) {
                if (b[1] <= a[1]) {
                    res.add(new int[]{b[0],b[1]});
                    bi++;
                }else {
                    res.add(new int[]{b[0],a[1]});
                    ai++;
                }
            }else {
                ai++;
            }
        }
//        int[][] finalRes = new int[res.size()][2];
//        for (int i = 0; i < res.size(); i++) {
//            finalRes[i] = res.get(i);
//        }
//        return finalRes;
        return res.toArray(new int[res.size()][2]); // toArray方法更节省时间
    }
}
