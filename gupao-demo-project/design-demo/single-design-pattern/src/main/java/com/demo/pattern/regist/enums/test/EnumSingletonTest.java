package com.demo.pattern.regist.enums.test;

import com.demo.pattern.regist.enums.EnumSingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {

    // 序列化不被破坏
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        EnumSingleton s1 = EnumSingleton.getInstance();
//        EnumSingleton s2 = null;
//        // 流操作：写对象
//        FileOutputStream out = null;
//        out = new FileOutputStream("/singleton.obj");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
//        objectOutputStream.writeObject(s1);
//        objectOutputStream.flush();
//        // 流操作：读对象
//        FileInputStream in = new FileInputStream("/singleton.obj");
//        ObjectInputStream objectInputStream = new ObjectInputStream(in);
//
//        /**
//         *  case 126:
//         *                 var4 = this.checkResolve(this.readEnum(unshared));
//         *                 return var4;
//         */
////        Enum<?> en = Enum.valueOf(cl, name);
////        result = en;
//        s2 = (EnumSingleton) objectInputStream.readObject();
//
//        System.out.println(s1);
//        System.out.println(s2);
//        System.out.println(s1 == s2);
//    }

    // 反射不被破坏
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cls = EnumSingleton.class;
        Constructor declaredConstructor = cls.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        // 报错：java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        //
        /**
         * newInstance方法判断是否为枚举
         *  if ((this.clazz.getModifiers() & 16384) != 0) {
         *             throw new IllegalArgumentException("Cannot reflectively create enum objects");
         *         }
         */
        EnumSingleton instance = (EnumSingleton) declaredConstructor.newInstance();
    }
}
