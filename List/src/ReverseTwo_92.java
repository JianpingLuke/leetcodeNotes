public class ReverseTwo_92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int count = 1;
            ListNode cur = head;
            while (count < left - 1) {
                cur = cur.next;
                count++;
            }
            ListNode prev = cur;
            cur = cur.next;
            ListNode remain = cur.next;
            while (count < right && remain != null) {
                prev.next = remain;
                cur.next = remain.next;
                remain.next = cur;
                remain = cur.next;
                count++;
            }
            return head;
        }
    }
}
