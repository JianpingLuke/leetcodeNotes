public class ReverseNodes_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        ListNode prev = head, cur = head.next, tail = head;
        while (cur != null) {
            int count = 1;
            ListNode flag = prev;
            for (int i = 1; i < k; i++) {
                flag = flag.next;
                if (flag == null) {
                    temp.next = prev;
                }
                return res.next; // 这种情况必定是最后一个了
            }
            while (count < k && cur != null) {
                prev.next = cur.next;
                cur.next = tail;
                tail = cur;
                cur = prev.next;
                count++;
            }
            if (count == k){
                temp.next = tail;
                temp = prev;
            }
            if (cur != null) {
                prev = cur;
                cur = cur.next;
                tail = prev;
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1), b= new ListNode(2), c = new ListNode(3), d = new ListNode(4),
        e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode res = reverseKGroup(a, 2);
    }

    public static void printl(ListNode l) {
        while (l != null) {
            System.out.print(l.val + "\t");
        }
    }

    public ListNode s2(ListNode head, int k) { // 使用迭代，整个逻辑会非常清晰
        if (k == 1 || head == null) return head;
        ListNode prev = head;
        for (int i = 1; i < k; i++) {
            prev = prev.next;
            if (prev == null) return head;
        }
        ListNode last = s2(prev.next, k), cur = head; // 函数功能的清晰认识很重要
        ListNode former;
        for (int i = 1; i <= k; i++) {
            former = cur.next;
            cur.next = last;
            last = cur;
            cur = former;
        }
        return last;
    }
}
