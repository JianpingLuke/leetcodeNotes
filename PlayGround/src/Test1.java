/*
* 测试输出用
* */

public class Test1 {
    public static void main(String[] args) {
        //TestLoop();
        TestListNode();
    }

    static void TestLoop() {
        int[] a = new int[]{1,2,3};
        for (int aa:a) {
            System.out.println(aa);
        }
        int[] b = new int[]{};
        for (int bb:b) {
            System.out.println("zy"); // 不会进入循环
        }
    }

    static void TestListNode() {
        ListNode a = new ListNode();
        System.out.println(a.next);
    }
}
