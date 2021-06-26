import java.util.*;

public class Preorder_N_ary_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return res;
    }

    public List<Integer> so2(Node root) { // 迭代的思想有点麻烦,并且只有stack才能实现这种极端的搜寻
        Stack<Node> s = new Stack<>();
        Node node = root;
        List<Integer> out = new ArrayList<>();
        while (!s.isEmpty() || node != null) {
            while (node != null) {
                out.add(node.val);
                for (int i = node.children.size()-1; i>=1; i--) {
                    s.add(node.children.get(i));
                }
                if (node.children.size() > 0)
                    node = node.children.get(0);
                else
                    node = null;
            }
                if(!s.isEmpty()) {
                    node = s.pop();
                }

        }
        return out;
    }

}
