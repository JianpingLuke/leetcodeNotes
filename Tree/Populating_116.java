import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Populating_116 {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> levelPoints = new LinkedList<>();
        levelPoints.add(root);
        while (!levelPoints.isEmpty()) {
            int len = levelPoints.size();
            Node[] curList = new Node[len];
            for (int i = 0; i < len; i++) {
                Node cur = levelPoints.poll();
                if (cur.left != null) levelPoints.add(cur.left);
                if (cur.right != null) levelPoints.add(cur.right);
                curList[i] = cur;
            }
            link(curList);
        }
        return root;
    }

    public void link(Node[] l) {
        for (int i = 0; i < l.length - 1; i++) {
            l[i].next = l[i+1];
        }
        l[l.length - 1].next = null;
    }
}
