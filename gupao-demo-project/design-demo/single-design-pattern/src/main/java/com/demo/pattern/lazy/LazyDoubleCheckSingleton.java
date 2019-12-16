package com.demo.pattern.lazy;

/**
 * 双重校验锁
 *
 * 适中的解决方案
 */
public class LazyDoubleCheckSingleton {

    // 解决指令重排序：volatile
    private volatile static LazyDoubleCheckSingleton LAZY_DOUBLE_CHECK_SINGLETON;

    private LazyDoubleCheckSingleton() {}

    public static LazyDoubleCheckSingleton getInstance() {
        if (LAZY_DOUBLE_CHECK_SINGLETON == null) {
            // 第二步：线程2正好走到这儿，但是需要等待锁，
            // 如果在synchronized中不再校验一次的话，当线程1释放了锁，线程2也会拿到锁再new一次，会new两次的
            synchronized (LazyDoubleCheckSingleton.class) {
                if (LAZY_DOUBLE_CHECK_SINGLETON == null) {
                    // 第一步：线程1走到这儿并没有new的时候
                    LAZY_DOUBLE_CHECK_SINGLETON = new LazyDoubleCheckSingleton();
                    // 执行new的时候的CPU指令，多线程的时候执行的顺序有可能和下面的不一致，称作指令重排序（volatile关键字解决指令重排序）
                    // 1.分配内存给这个对象
                    // 2.初始化对象
                    // 3.将初始化好的对象和内存地址建立关联关系，赋值
                    // 4.用户初次访问
                }
            }
        }
        return LAZY_DOUBLE_CHECK_SINGLETON;
    }
}
