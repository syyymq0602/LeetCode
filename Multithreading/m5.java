package Multithreading;

/**
 * 使用5个线程将一个数字从0累加到1000
 */
public class m5 {
    public static int count = 0;
    private static Object obj = new Object();

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        for (int i = 0; i < 3; i++) {
            new Thread(mt,"线程" + i).start();
        }
    }

    static class MyThread implements Runnable{
        @Override
        public void run() {
            while (true){
                synchronized (obj){
                    if(count > 1000){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + "：" + count++);
                    Thread.yield();
                }
            }
        }
    }
}
