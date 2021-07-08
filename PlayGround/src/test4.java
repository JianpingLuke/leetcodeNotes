/*
* test Thread
* */
public class test4 extends Thread{
    int i = 0;
    public void run() {
        for (; i < 100; i++)
            System.out.println(getName() + " " + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            System.out.println(Thread.currentThread().getName()
                    + " : " + i);
            if (i == 20) {
                new test4().start();
                new test4().start();
            }
        }
    }
}
