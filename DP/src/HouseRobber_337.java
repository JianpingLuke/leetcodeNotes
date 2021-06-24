import javafx.beans.value.WritableIntegerValue;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber_337 {
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dp(TreeNode node) { // 二维dp数组，对dp和回溯的极致理解，前两行就是已经做好了dp后面的元素和回溯到开头，二维数组使得dp少一层结构需要判断。
        int[] left = dp(node.left);
        int[] right = dp(node.right);
        int do_rob = node.val + left[0] + right[0];
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 注意不抢也可能会使总金额更高
        return new int[]{not_rob, do_rob};
    }

    Map<TreeNode, Integer> node_value = new HashMap<>(); // 不是修剪，是消除dp计算中的重叠

    public int rob2(TreeNode root) {
        if (root == null) return 0;
        if (node_value.containsKey(root)) return node_value.get(root);
        int left = root.left == null ? 0 : rob2(root.left.left) + rob2(root.left.right);
        int right = root.right == null ? 0 : rob2(root.right.left) + rob2(root.right.right);
        int do_rob = root.val + left + right;
        int not_rob = rob2(root.left) + rob2(root.right);
        int res = Math.max(do_rob, not_rob);
        node_value.put(root, res);
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {};
    TreeNode(int val) { this.val = val; };
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}