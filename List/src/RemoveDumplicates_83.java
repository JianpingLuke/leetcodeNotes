public class RemoveDumplicates_83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode first = head, second = head.next;
            while (second != null) {
                if (first.val != second.val) {
                    first = first.next;
                    second = second.next;
                } else {
                    while (second != null && first.val == second.val) {
                        second = second.next;
                    }
                    first.next = second;
                }
            }
            return head;
        }
    }
}
