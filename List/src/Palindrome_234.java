public class Palindrome_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode a = head, b = head, c = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        if (b != null) a = a.next;
        a = reverse(a);
        while (a != null) {
            if (a.val != c.val) return false;
            a = a.next;
            c = c.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node) {
        ListNode prev = null, cur = node, remain = null;
        while (cur != null) {
            remain = cur.next;
            cur.next = prev;
            prev = cur;
            cur = remain;
        }
        return prev;
    }

    ListNode left;
    public boolean so2(ListNode head) { // 递归的思想，但是速率很慢，笔记是要把所有的元素都比较一遍。
        left = head;
        return helper(head);
    }
    public boolean helper(ListNode right) {
        if (right == null) return true;
        boolean res = helper(right.next);
        res = (res) && (left.val == right.val);
        left = left.next;
        return res;
    }

    public boolean so3(ListNode head) { // 改良一下，还是很慢
        ListNode a = head, b = head;
        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
        }
        left = head;
        if (b != null) a = a.next;
        return helper2(a);
    }
    public boolean helper2(ListNode right) {
        if (right == null) return true;
        boolean res = helper(right.next);
        res = (res) && (left.val == right.val);
        left = left.next;
        return res;
    }
}
