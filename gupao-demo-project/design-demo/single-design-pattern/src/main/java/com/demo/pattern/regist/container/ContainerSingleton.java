package com.demo.pattern.regist.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * spring中的单例就是用的此方式
 *
 * 方便对象的管理
 *  但是存在线程安全问题
 */
public class ContainerSingleton {
    // ConcurrentHashMap自带的方法是线程安全的
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton() {}

    public static final Object getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 解决getInstance方法的线程安全问题
        synchronized (ioc) {
            if (!ioc.containsKey(className)){
                Class<?> cls = Class.forName(className);
                Object obj = cls.newInstance();
                ioc.put(className, obj);
                return obj;
            }
            return ioc.get(className);
        }
    }
}
