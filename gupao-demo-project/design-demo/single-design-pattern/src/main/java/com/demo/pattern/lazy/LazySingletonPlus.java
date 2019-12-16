package com.demo.pattern.lazy;

/**
 * 懒汉模式
 * 需要的时候初始化
 * 线程安全
 *  但是synchronized的对性能有影响
 *  整个类都会锁定
 */
public class LazySingletonPlus {

    private static LazySingletonPlus LAZY_SINGLETON;

    private LazySingletonPlus() {}

    public static synchronized LazySingletonPlus getInstance() {
        if (LAZY_SINGLETON == null) {
            LAZY_SINGLETON = new LazySingletonPlus();
        }
        return LAZY_SINGLETON;
    }
}
