public class BSTtoGST_1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null)
            return null;
        bstToGst(root.right); // 不需要判断返回值是否为null，因为不依赖它计算val
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
