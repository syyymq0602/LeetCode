package Multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用无锁实现 3 个线程交叉打印 1~100 的数字
 */
public class m6 {

    final static AtomicInteger at = new AtomicInteger(1);
    final static int total = 100;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true){
                int num = at.get();
                if(num > total){
                    break;
                }
                if(num % 3 == 1){
                    System.out.println("t1---->" + num);
                    at.getAndIncrement();
                }
            }
        },"T1");

        Thread t2 = new Thread(() -> {
            while (true){
                int num = at.get();
                if(num > total){
                    break;
                }
                if(num % 3 == 2){
                    System.out.println("t2---->" + num);
                    at.getAndIncrement();
                }
            }
        },"T2");

        Thread t3 = new Thread(() -> {
            while (true){
                int num = at.get();
                if(num > total){
                    break;
                }
                if(num % 3 == 0){
                    System.out.println("t3---->" + num);
                    at.getAndIncrement();
                }
            }
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
