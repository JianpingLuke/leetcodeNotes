public class MaximumBT_654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int l, int r, int[] nums) {
        if (l > r) return null;
        int idx = l, max = nums[l]; // 注意i从l开始，所以idx从l开始算
        for (int i = l; i <= r; i++){
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(nums[idx]);
        root.left = helper(l,idx - 1, nums); // 注意l和r不一定是0和length,因为有可能取中间的子树
        root.right = helper(idx + 1, r, nums);
        return root;
    }

}
