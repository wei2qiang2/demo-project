package com.demo.pattern.threadlocal.test;

import com.demo.pattern.threadlocal.ThreadLocalSingleton;

public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
        System.out.println(Thread.currentThread().getName() + ":" + ThreadLocalSingleton.getInstance());
    }
}
