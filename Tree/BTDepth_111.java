import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTDepth_111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (true) {
            depth++;
            int len = q.size();
            for (int i = 0; i < len; i++) { // 注意q.size()在变，不能用i < q.size()
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) q.add(cur.left);
                if (cur.right!= null) q.add(cur.right);
            }
        }
    }

    public int s2(TreeNode root) {
        if (root == null) return 0;
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);
        return bfs(1, stack);
    }

    public int bfs(int depth, List<TreeNode> stack) {
        if (stack.size() == 0) return depth;
        List<TreeNode> temp = new ArrayList<>();
        for (TreeNode node : stack) {
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) temp.add(node.left);
            if (node.right != null) temp.add(node.right);
        }
        depth++;
        return bfs(depth, temp);
    }
}

