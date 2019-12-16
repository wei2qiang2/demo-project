package com.demo.pattern.hungry;

/**
 * 饿汉类型单例模式
 *
 * 非线程安全
 * 虚拟机加载类的时候就会创建对象，浪费内存，
 *  只适用于创建少量的对象，当对象的数量太多就不适用了
 */
public class HungrySingleton {
    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();
    private HungrySingleton() {}
    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

    // 解决序列化破坏单例问题
    // 重写该方法，只是用原本打单例对象覆盖了反序列化创建的对象
    // 最终还是创建了两次对象，发生再JVM层面，相对来说比较安全
    // 之前反序列化生成的对象会被GC回收
    private Object readResovle() {
        return HUNGRY_SINGLETON;
    }
}
