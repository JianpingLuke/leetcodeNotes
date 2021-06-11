import java.util.LinkedList;
import java.util.List;

public class BT_preorder_144 {
    List<Integer> res = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}
