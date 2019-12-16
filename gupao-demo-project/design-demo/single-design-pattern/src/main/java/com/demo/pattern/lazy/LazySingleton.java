package com.demo.pattern.lazy;

/**
 * 懒汉模式
 * 需要的时候初始化
 * 非线程安全
 */
public class LazySingleton {

    private static LazySingleton LAZY_SINGLETON;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (LAZY_SINGLETON == null) {
            LAZY_SINGLETON = new LazySingleton();
        }
        return LAZY_SINGLETON;
    }
}
