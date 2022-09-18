package Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3个线程按序打印 1 ~ 100 的数字
 */
public class m4 {

    public static int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition ca = lock.newCondition();
    private Condition cb = lock.newCondition();
    private Condition cc = lock.newCondition();

    private void printOne(){
        lock.lock();
        try {
            while (num % 3 != 1 && num <= 100){
                ca.await();
            }
            System.out.println(Thread.currentThread().getName() + "：" + num);
            num++;
            cb.signal();
        }catch (InterruptedException e){

        }
        finally {
            lock.unlock();
        }
    }

    private void printTwo(){
        lock.lock();
        try {
            while (num % 3 != 2 && num <= 100){
                cb.await();
            }
            System.out.println(Thread.currentThread().getName() + "：" + num);
            num++;
            cc.signal();
        }catch (InterruptedException e){

        }
        finally {
            lock.unlock();
        }
    }

    private void printThree(){
        lock.lock();
        try {
            while (num % 3 != 0 && num <= 100){
                cc.await();
            }
            System.out.println(Thread.currentThread().getName() + "：" + num);
            num++;
            ca.signal();
        }catch (InterruptedException e){

        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m4 mm = new m4();
        Thread t1 = new Thread(()->{
            while (num < 101){
                mm.printOne();
            }
        },"线程1");

        Thread t2 = new Thread(()->{
            while (num < 99){
                mm.printTwo();
            }
        },"线程2");

        Thread t3 = new Thread(()->{
            while (num < 99){
                mm.printThree();
            }
        },"线程3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread implements Runnable {

        private static Object lock = new Object();   //静态对象
        private static int count = 0;               //当前打印到的数字
        int no;

        public MyThread(int no) {
            this.no = no;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count >= 100) {
                        break;
                    } else if (count % 3 == no) {
                        count++;
                        int cur = this.no + 1;
                        System.out.println("第" + cur + "个线程" + "打印了" + count);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();        //唤醒其他等待线程
                }
            }
        }
    }
}
