import java.util.HashMap;
import java.util.Map;

public class ConstructBT_106 {
    Map<Integer, Integer> inorderIndex;
    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndex = new HashMap<>();
        rootIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, postorder.length - 1);
    }

    public TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootValue = postorder[rootIndex--];
        TreeNode root = new TreeNode(rootValue);
        root.right = arrayToTree(postorder, inorderIndex.get(rootValue) + 1, right); // 特别注意, 先出现右子树的根！
        root.left = arrayToTree(postorder, left, inorderIndex.get(rootValue) - 1);
        return root;
    }
}
