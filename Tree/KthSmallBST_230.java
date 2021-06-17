public class KthSmallBST_230 {
    int count = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return ans;
    }

    public void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        count++;
        if (count == k ) ans = root.val;
        helper(root.right, k);
    }
} // 对先序遍历的实际应用，求由小到大
