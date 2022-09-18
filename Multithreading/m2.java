package Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程循环打印1-100，线程1打印奇数，线程2打印偶数
 */
public class m2 {

    private static int num = 1;
    Lock lock = new ReentrantLock();
    Condition conA = lock.newCondition();
    Condition conB  = lock.newCondition();

    public void printOdd(){
        lock.lock();
        try {
            while (num % 2 == 0){
                conA.await();
            }
            if(num > 100){
                return;
            }
            System.out.println(Thread.currentThread().getName() + " " + num);
            num++;
            conB.signal();
        }
        catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }

    public void printEven(){
        lock.lock();
        try {
            while (num % 2 == 1){
                conB.await();
            }
            if(num > 100){
                return;
            }
            System.out.println(Thread.currentThread().getName() + " " + num);
            num++;
            conA.signal();
        }
        catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m2 m2m = new m2();
        Thread t1 = new Thread(()->{
            while (num <= 100){
                m2m.printOdd();
            }
        },"奇数线程");

        Thread t2 = new Thread(()->{
            while (num <= 100){
                m2m.printEven();
            }
        },"偶数线程");

        t1.start();
        t2.start();
    }
}
