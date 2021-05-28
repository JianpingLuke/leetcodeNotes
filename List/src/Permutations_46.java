import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> l = new ArrayList<>();
        permute_once(l ,nums);
        return res;
    }
    public void permute_once(List<Integer> l, int[] nums) { // 抽象成树
        if (l.size() == nums.length) {
            List<Integer> l1 = new ArrayList<>(l);
            res.add(l1);
            return;
        }
        for (int num : nums) {
            if (l.contains(num)) continue; // 去除重复点
            l.add(num); // 增加树的节点
            permute_once(l, nums); // 去下一层的判断
            l.remove(l.size() - 1); // 这一节点以下的遍历完毕，返回上一层
        }
    }

    List<List<Integer>> ls = new ArrayList<>();
    public List<List<Integer>> so(int[] nums) { // 每两个元素交换一次，达到全排列
        helper(nums, 0, nums.length - 1);
        return ls;
    }
    public void helper(int[] a, int start, int end) {
        if (start == end) {
            List<Integer> out = new ArrayList<>();
            for (int i : a){
                out.add(i);
            }
            ls.add(out);
        }else {
            for (int i = start; i <= end; i++) {
                int t1 = a[i];
                a[i] = a[start];
                a[start] = t1;
                helper(a, start + 1, end);
                int t2 = a[i];
                a[i] = a[start];
                a[start] = t2;
            }
        }
    }
}
