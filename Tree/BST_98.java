public class BST_98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean left = helper(root.left, null, root.val); // 注意val在min和max之间，别搞反了
        boolean right = helper(root.right, root.val, null); // 每次迭代都是更新区间
        return left && right;
    }

    public boolean helper(TreeNode node, Integer min, Integer max) { // 技巧：Integer 传递 null 作为无穷极限
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max); // min 或 max 分别记录了上一次右|左转时候的值
        // 向左小值会更新，向右大值会更新
    }
}
