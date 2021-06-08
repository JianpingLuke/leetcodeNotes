import java.util.*;

public class BTlevelOrder_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {// FIFO: Stack vs FILO: Queue
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curl = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                curl.add(cur.val);
                if (cur.left != null)   q.add(cur.left);
                if (cur.right != null)   q.add(cur.right);
            }
            res.add(curl);
        }
        return res;
    }
}
