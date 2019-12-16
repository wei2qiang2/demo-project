package com.demo.pattern.threadlocal;

/**
 * ThreadLocal:伪线程安全
 * 多数据源切换
 *
 * 同一个线程里面是同一个对象
 * 在线程的内部是线程安全的
 *
 * ThreadLocalMap<线程的Key, 自己设置的值>
 */
public class ThreadLocalSingleton {

    private ThreadLocalSingleton() {}
    private static final ThreadLocal<ThreadLocalSingleton> THREADLOCAL_INSTANCE = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance() {
        return THREADLOCAL_INSTANCE.get();
    }
}
