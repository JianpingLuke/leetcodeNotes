import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees_652 {
    Map<String, Integer> rm = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return res;
    }

    private String helper(TreeNode root) {
        if (root == null) return "";
        String curr = new StringBuilder()
                .append(root.val).append(":")
                .append(helper(root.left)).append(",")
                .append(helper(root.right)).append(";")
                .toString();
        int temp = rm.getOrDefault(curr, 0);
        if (temp == 1) res.add(root);
        temp++;
        rm.put(curr, temp);
        return curr;
    }
}
// 字符串化的方法，比较特殊
// 但正是这样，把抽象的序列给具体化了，便于判断