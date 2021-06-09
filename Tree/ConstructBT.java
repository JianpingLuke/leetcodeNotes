import java.util.HashMap;
import java.util.Map;

public class ConstructBT {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>(); // 用hash map存下对应关系
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }
}

/*
* 感叹迭代的思想之巧妙
* 一个复杂的事情可以分解成简单的事情，而这些简单的事情又是由这种方式生成的
* 一直迭代下去，只有最底层的是具体的，其上都是由此生成的抽象的函数表示
* 这也许就是编程的思想和人类的大脑不同之处，人类需要从具体的往抽象的推，而这里就是从抽象的不断迭代直到找到具体的
* dp也是用了相同的思想，本质并无区别
* 了解了这样的思想之后，发现规律就是最重要的
* 在这里就是发现root的存在规律
* 在dp中就是找到状态转移方程
* 没什么可难的，只不过是思想方式的转变而已。
* */