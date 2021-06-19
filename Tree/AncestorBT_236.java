public class AncestorBT_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null; // 列举可能出现的四种不同情况
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}

// 欣赏递归思想的终极之美