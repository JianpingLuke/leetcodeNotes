import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BT_Inorder_94 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return res;
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) { // 利用stack的思想
        List < Integer > res2 = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res2.add(curr.val);
            curr = curr.right;
        }
        return res2;
    }

}
