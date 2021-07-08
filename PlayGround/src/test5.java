/*
* test runnable
* */

public class test5 implements Runnable{
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName() +
                    " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +
                    " " + i);
            if (i == 20) {
                test5 rtt = new test5();
                new Thread(rtt, "新线程1").start();
                new Thread(rtt, "新线程2").start();
            }
        }
    }
}
