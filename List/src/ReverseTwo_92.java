public class ReverseTwo_92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            int count = 1;
            ListNode cur = head;
            while (count < left - 1) {
                cur = cur.next;
                count++;
            }
            ListNode remain = null;
            if (count != left){ // 并不一定有remain的存在，如果没有，则是第一个开始就转，此时单独讨论。
                remain = cur;
                cur = cur.next;
                count++;
            }
            ListNode prev = cur, tail = cur;
            if (cur == null) return head;
            cur = cur.next;
            count++;
            while (count <= right  && cur != null) { // 注意换位的规范
                prev.next = cur.next;
                cur.next = tail;
                tail = cur;
                cur = prev.next;
                count++;
            }
            if (remain == null){
                return tail;
            }
            remain.next = tail;
            return head;
        }
    }
}
