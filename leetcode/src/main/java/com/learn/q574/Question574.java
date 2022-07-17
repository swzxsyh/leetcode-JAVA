package com.learn.q574;

import java.util.concurrent.*;

/**
 * 给你一个类：
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个Foo实例。
 * <p>
 * 线程 A 将会调用 first() 方法
 * 线程 B 将会调用second() 方法
 * 线程 C 将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 * <p>
 * 提示：
 * <p>
 * 尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
 * 你看到的输入格式主要是为了确保测试的全面性。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/print-in-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question574 {

    public Semaphore semaphore_first_two = new Semaphore(0);
    public Semaphore semaphore_two_second = new Semaphore(0);


    public static void main(String[] args) {
        Question574 question = new Question574();

        Thread t1 = new Thread(() -> {
            try {
                question.first(() -> System.out.println("One"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                question.second(() -> System.out.println("Two"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                question.third(() -> System.out.println("Three"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
        t3.start();
    }

    public Question574() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphore_first_two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore_first_two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphore_two_second.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore_two_second.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
