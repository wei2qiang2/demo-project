package com.demo.pattern.hungry.test;

import com.demo.pattern.hungry.HungrySingleton;

/**
 * 演示序列化破坏饿汉单例
 * 用饿汉单例模式创建一个对象obj1,序列化的创世将对象写入文件
 * 再从文件中匠此对象读取到obj2中
 * 比较obj1和obj2是否相等
 */
public class HungrySingletonSerializableTest {

    private static final HungrySingleton obj1 = HungrySingleton.getInstance();
    private static HungrySingleton obj2 = null;

    public static void main(String[] args) {

    }
}
