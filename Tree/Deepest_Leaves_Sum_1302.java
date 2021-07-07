import java.util.LinkedList;
import java.util.Queue;

public class Deepest_Leaves_Sum_1302 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> rl = new LinkedList<>();
        rl.add(root);
        int res = 0;
        while (!rl.isEmpty()) {
            int len = rl.size();
            res = 0;
            for (int i = 0; i < len; i++) {
                TreeNode child = rl.remove();
                if (child == null) continue;
                if (child.left != null)
                    rl.add(child.left);
                if (child.right != null)
                    rl.add(child.right);
                res += child.val;
            }
        }
        return res;
    }

    int height(TreeNode root){ // 1. 找到高度 2. 算出h=1的所有值 -- 减少了很多求和计算
        if(root==null) return 0;

        int lh=height(root.left);
        int rh=height(root.right);
        return Math.max(lh,rh)+1;
    }
    public int deepestLeavesSum2(TreeNode root,int h) {
        if(root==null)return 0;
        int sum=0;

        if(h==1){
            sum+=root.val;
        }

        sum+=deepestLeavesSum2(root.left,h-1);
        sum+=deepestLeavesSum2(root.right,h-1);
        return sum;
    }
    public int deepestLeavesSum2(TreeNode root) {
        if(root==null)return 0;
        int h=height(root);
        return deepestLeavesSum2(root,h);
    }
}
