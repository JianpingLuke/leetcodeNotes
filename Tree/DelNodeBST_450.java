public class DelNodeBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key);
        if (root.val < key) root.right = deleteNode(root.right,key);
        if (root.val == key) {
            TreeNode r = root.right;
            TreeNode l = root.right;
            if (r == null) root = root.left;
            else { // 利用右子树肯定比左子树大的性质，暴力接在右子树最小的node后面。
                TreeNode temp = root;
                root = r;
                while (l.left != null) l = l.left;
                l.left = temp.left;
            }
        }
        return root;
    }
}
