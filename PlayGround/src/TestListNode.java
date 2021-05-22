public class TestListNode {
    public static void main(String[] args) {
        System.out.println("Test List Node Ground");
        //Test1();
        Test2();
    }

    static void Test1() {
        int[] a = new int[]{1,2,3,4,5};
        ListNode al = creatList(a);
        printList(al);
    }

    static void Test2() {
        int[] a = new int[]{1,2,3,4,5};
        ListNode al = creatList(a);
        ListNode b = Testfunc(al);
        printList(al);
    }

    static ListNode Testfunc(ListNode a) {
        while (a != null) {
            a = a.next; // 不会改变原a
        }
        return a;
    }

    static ListNode creatList(int[] a) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        for (int aa : a) {
            res.next = new ListNode(aa);
            res = res.next;
        }
        return head.next;
    }

    static void printList(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
