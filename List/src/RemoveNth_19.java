/*
* https://leetcode.com/problems/remove-nth-node-from-end-of-list/
* 19. Remove Nth Node From End of List
* key : two points, list
* */

public class RemoveNth_19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head, slow = head;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            if (fast == null) return head.next; // 最易错的一步，删除第一个元素，即不可进入while，即slow应该是head之前的元素，此时单独讨论
            while (fast != null) {
                fast = fast.next;
                if (fast != null)   slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
        }
    }
}
