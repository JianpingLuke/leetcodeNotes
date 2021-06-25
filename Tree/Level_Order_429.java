import java.util.*;

public class Level_Order_429 {
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

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<Node> cur = new LinkedList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<Integer> listnode = new LinkedList<>();
            int len = cur.size();
            for (int i = 0; i < len; i++) {
                Node onenode = cur.remove();
                for (Node child : onenode.children) {
                    cur.add(child);
                }
                listnode.add(onenode.val);
            }
            //Collections.reverse(listnode);
            if (!listnode.isEmpty()) res.add(listnode);
        }
        return res;
    }
}
/*
* 注意！
* queue 与 stack 插入都一样
* queue 先删除后插入的
* stack 先删除新插入的
* */