public class Swap_pairs_24 {
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode res = head.next; // 注意head已经不是原来位置了，head后面的一个到了开头
            ListNode prev = new ListNode(0),cur = head, remain = head.next;
            while (cur != null && cur.next != null) {
                prev.next = cur.next;
                remain = cur.next.next;
                cur.next.next = cur;
                cur.next = remain;
                prev = cur;
                cur = cur.next;
            }
            return res;
        }
    }
}
