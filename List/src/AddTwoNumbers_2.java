/*
*  https://leetcode.com/problems/add-two-numbers/
*  2. Add Two Numbers
*  key: iterative
* */
public class AddTwoNumbers_2 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return Helper(l1, l2, 0);
        }

        public ListNode Helper(ListNode l1, ListNode l2, int pass) {
            if (l1 == null && l2 == null) {
                if (pass == 0) {
                    return null;
                } else {
                    return new ListNode(pass);
                }
            }
            int val1 = 0, val2 = 0;
            ListNode next1 = null, next2 = null;
            if (l1 != null) { val1 = l1.val; next1 = l1.next; }
            if (l2 != null) { val2 = l2.val; next2 = l2.next; }
            ListNode n = new ListNode((val1 + val2 + pass) % 10);
            n.next = Helper(next1, next2, (val1 + val2 + pass) / 10);
            return  n;
        }
    }
}

/*
*  using a iterative method will simply codes huge
* 迭代的思想：
* 1. 找出首部情况
* 2. 分析连接后面迭代的那个点
* 3. 尾部情况检查
* null的讨论：
* null可以作为一种特殊情况来讨论，没必要在只有一个为null时单独讨论
* 此时为null的那个点就滞留在null处即可
* O(n) O(1)
* */
