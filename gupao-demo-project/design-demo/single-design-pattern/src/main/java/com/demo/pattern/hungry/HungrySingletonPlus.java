package com.demo.pattern.hungry;

/**
 * 饿汉类型单例模式
 *
 * 非线程安全
 * 虚拟机加载类的时候就会创建对象，浪费内存，
 *  只适用于创建少量的对象，当对象的数量太多就不适用了
 * 此种方式不同的是在静态代码块中初始化的，至于和定义的时候初始化有什么区别暂时还未得知
 */
public class HungrySingletonPlus {
    private static final HungrySingletonPlus HUNGRY_SINGLETON;
    static {
        HUNGRY_SINGLETON = new HungrySingletonPlus();
    }
    private HungrySingletonPlus() {}
    public static HungrySingletonPlus getInstance() {
        return HUNGRY_SINGLETON;
    }
}
