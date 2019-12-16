package com.demo.pattern.threadlocal.test;

import com.demo.pattern.threadlocal.ThreadLocalSingleton;

public class ThreadLocalSingletonTest {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() +":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() +":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() +":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() +":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() +":" + ThreadLocalSingleton.getInstance());

        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());
        Thread t3 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();
        t3.start();
        System.out.println("main end");

        /**
         * 输出结果：
         * main:com.demo.pattern.threadlocal.ThreadLocalSingleton@5a61f5df
         * main:com.demo.pattern.threadlocal.ThreadLocalSingleton@5a61f5df
         * main:com.demo.pattern.threadlocal.ThreadLocalSingleton@5a61f5df
         * main:com.demo.pattern.threadlocal.ThreadLocalSingleton@5a61f5df
         * main:com.demo.pattern.threadlocal.ThreadLocalSingleton@5a61f5df
         * main end
         * Thread-1:com.demo.pattern.threadlocal.ThreadLocalSingleton@446145dd
         * Thread-1:com.demo.pattern.threadlocal.ThreadLocalSingleton@446145dd
         * Thread-1:com.demo.pattern.threadlocal.ThreadLocalSingleton@446145dd
         * Thread-1:com.demo.pattern.threadlocal.ThreadLocalSingleton@446145dd
         * Thread-1:com.demo.pattern.threadlocal.ThreadLocalSingleton@446145dd
         * Thread-2:com.demo.pattern.threadlocal.ThreadLocalSingleton@69147d67
         * Thread-2:com.demo.pattern.threadlocal.ThreadLocalSingleton@69147d67
         * Thread-0:com.demo.pattern.threadlocal.ThreadLocalSingleton@5d714c87
         * Thread-0:com.demo.pattern.threadlocal.ThreadLocalSingleton@5d714c87
         * Thread-0:com.demo.pattern.threadlocal.ThreadLocalSingleton@5d714c87
         * Thread-0:com.demo.pattern.threadlocal.ThreadLocalSingleton@5d714c87
         * Thread-2:com.demo.pattern.threadlocal.ThreadLocalSingleton@69147d67
         * Thread-2:com.demo.pattern.threadlocal.ThreadLocalSingleton@69147d67
         * Thread-2:com.demo.pattern.threadlocal.ThreadLocalSingleton@69147d67
         * Thread-0:com.demo.pattern.threadlocal.ThreadLocalSingleton@5d714c87
         * Disconnected from the target VM, address: '127.0.0.1:0', transport: 'socket'
         *
         * Process finished with exit code 0
         */
    }
}
