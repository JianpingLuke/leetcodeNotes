/*
* https://leetcode.com/problems/merge-k-sorted-lists/
* 23. Merge k Sorted Lists
* key : priorityQueue, minHeap, Two-divide
* */

import java.util.PriorityQueue;

public class MergeKSortedList_23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val); // PriorityQueue 的运用减少了很多步骤
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            for (ListNode list : lists) {
                while (list != null) {
                    minHeap.add(list);
                    list = list.next;
                }
            }
            while (!minHeap.isEmpty()) {
                dummy.next = minHeap.poll();
                dummy = dummy.next;
                dummy.next = null;
            }
            return head.next;
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) return null;
            return dividList(lists, 0, lists.length - 1);
        }
        ListNode dividList(ListNode[] lists, int l, int r) { // 引入二分法，大大减少了计算的时间
            if (l == r) return lists[l];
            int mid = (l + r) / 2;
            ListNode l1 = dividList(lists, l, mid);
            ListNode l2 = dividList(lists, mid + 1, r);
            return mergeList(l1, l2);
        }
        ListNode mergeList(ListNode a, ListNode b) {
            ListNode ab = new ListNode(-1);
            ListNode res = ab;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    ab.next = a;
                    a = a.next;
                }else {
                    ab.next = b;
                    b = b.next;
                }
                ab = ab.next;
            }
            ab.next = a!=null ? a : b;
            return res.next;
        }
    }
}
