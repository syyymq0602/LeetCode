package Multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程循环打印ABC，线程一打印A，线程二打印B，线程三打印C，打印10遍即可。
 */
public class m1 {

    private int flag = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (flag != 1) {
                conditionA.await();
            }
            System.out.print("A");
            conditionB.signal();
            flag = 2;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (flag != 2) {
                conditionB.await();
            }
            System.out.print("B");
            conditionC.signal();
            flag = 3;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (flag != 3) {
                conditionC.await();
            }
            System.out.println("C");
            conditionA.signal();
            flag = 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        m1 printABC = new m1();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) printABC.printA();
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) printABC.printB();
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) printABC.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
