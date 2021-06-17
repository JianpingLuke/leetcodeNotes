import java.util.List;

public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head;
        while (cur.next != null) {
            ListNode remain = cur.next;
            cur.next = prev;
            prev = cur;
            cur = remain;
        }
        cur.next = prev;
        return cur;
    }

    public ListNode s2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = s2(head.next);
        head.next.next = head; // 此时head和head.next之间有双向指针，即成环
        head.next = null; // 消除残留的指针
        return last;
    }
}
