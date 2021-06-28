public class InsertBST_701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) root.left = insertIntoBST(root.left, val); // 注意，这是为了把新加入的节点插上，易错
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        return root;
    }
}
// 插入节点，插入的逻辑要加上，不能简单return或不返回，这里是要新加入一个链接的关系，必定会有Left或right的赋值