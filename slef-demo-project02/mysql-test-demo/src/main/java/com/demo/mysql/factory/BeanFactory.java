package com.demo.mysql.factory;

import java.util.HashMap;
import java.util.Random;

public class BeanFactory {

    private static HashMap<String, Object> beanList = new HashMap<>();

    /**
     * 当没有某个类的实例的时候
     * 恰好多个线程并发请求这个类的实例，那么会同时创建多个实例
     * 但是Map中存放的key是实例的类名称，又只能存放一个进去
     * 所以说Map中不会有重复的实例
     *
     * @param cl
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public synchronized static Object getInstance(Class cl) {
        if (beanList.containsKey(cl.getName())) {
            return beanList.get(cl.getName());
        } else {
            Object newInstance = null;
            try {
                newInstance = cl.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            beanList.put(cl.getName(), newInstance);
            return newInstance;
        }
    }

    public static void main(String[] args){
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                Random r = (Random) getInstance(Random.class);
                System.out.println(Thread.currentThread().getName() + ":" + getInstance(Random.class));
            }).start();
        }
    }
}
