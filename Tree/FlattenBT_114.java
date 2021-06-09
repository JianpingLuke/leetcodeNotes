public class FlattenBT_114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        if (root.left != null) {
            TreeNode leftTail = root.left;
            while (leftTail.right != null) leftTail = leftTail.right;
            root.right = root.left;
            leftTail.right = temp;
            root.left = null; // 不要忘了这是树，将左子树计null！
        }
    }
}
