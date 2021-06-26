public class BSTtoGreaterT_538 {
    int val = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right); // 如果采用temp = convertBST(root.right)则会只保留右子树加的值，而左子树的值也加上的话就要用全局变量了（因为局内变量不可能既往上走又往下走
        val += root.val;
        root.val = val;
        convertBST(root.left);
        return root;
    }
}
