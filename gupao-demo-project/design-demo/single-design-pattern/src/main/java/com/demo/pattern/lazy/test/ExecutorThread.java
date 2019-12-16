package com.demo.pattern.lazy.test;

import com.demo.pattern.lazy.LazySingleton;
import com.demo.pattern.lazy.LazySingletonPlus;

public class ExecutorThread implements Runnable {

    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance.toString());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ExecutorThread());
        Thread t2 = new Thread(new ExecutorThread());

        t1.start();
        t2.start();

        System.out.println("excutor execute end ...");
    }
}
