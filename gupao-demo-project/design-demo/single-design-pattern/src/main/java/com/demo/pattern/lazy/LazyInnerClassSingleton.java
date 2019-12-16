package com.demo.pattern.lazy;

/**
 * 性能最优的写法
 *
 * 静态内部内单例模式
 *
 * 整个代码中都没有synchronized关键字，效率有所提升
 *
 * 当加载外面类的时候又会首先加载内部类（内部类会比外部类优先加载）
 *
 *  暴露的问题：被反射攻击，序列化破坏单例
 *      虽然构造方法私有了，但是逃不过反射的攻击
 *
 */
public class LazyInnerClassSingleton {

    // 虽然构造方法私有了，但是逃不过反射的攻击
    private LazyInnerClassSingleton() {
        //　解决反射破坏单例
        if (LazyHolder.LAZY_INNER_CLASS_SINGLETON != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    // 当加载外面类执行此方法的时候又会调用内部内的逻辑，而内部类正好又是static和final的，所以不会再次执行
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.LAZY_INNER_CLASS_SINGLETON;
    }
    // LazyHolder的逻辑需要等到外部使用的时候才执行，达到了懒汉的特性
    // JVM底层的实现逻辑，巧妙的避免了多线程问题
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY_INNER_CLASS_SINGLETON = new LazyInnerClassSingleton();
    }
}
