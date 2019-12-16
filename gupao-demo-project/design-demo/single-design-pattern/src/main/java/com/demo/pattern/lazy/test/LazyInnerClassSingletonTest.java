package com.demo.pattern.lazy.test;

import com.demo.pattern.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * 测试反射攻击内部内懒汉单例模式
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) throws Exception {
        Class<?> cls = LazyInnerClassSingleton.class;
        // 反射获取构造函数
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(null);
        // 授权
        declaredConstructor.setAccessible(true);
        //　创建
//        Object obj1 = declaredConstructor.newInstance();
        // 单例创建
        LazyInnerClassSingleton obj2 = LazyInnerClassSingleton.getInstance();
        // 看是否相等
//        System.out.println(obj1 == obj2); // false,两者创建的对象不相等，破坏了单例

    }
}
