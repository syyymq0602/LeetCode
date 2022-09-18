package Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * 写一个死锁的例子
 */
public class m3 {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            synchronized (o1){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o2){
                    System.out.println("释放" + Thread.currentThread().getName());
                }
            }
        },"T1");

        Thread t2 = new Thread(()->{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (o1){
                    System.out.println("释放" + Thread.currentThread().getName());
                }
            }
        },"T2");

        t1.start();

        t2.start();
    }
}
