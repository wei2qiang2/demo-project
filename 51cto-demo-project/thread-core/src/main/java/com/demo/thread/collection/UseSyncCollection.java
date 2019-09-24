package com.demo.thread.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * 集合遍历的时候修改出现并发修改异常
 */
public class UseSyncCollection {

    /**
     * Exception in thread "main" java.util.ConcurrentModificationException
     * @param list
     * @return
     */
    public Collection<String> m1(Vector<String> list){
        for (String temp: list) {
            if ("3".equals(temp)){
                list.remove(temp);
            }
        }
        return list;
    }

    /**
     * Exception in thread "main" java.util.ConcurrentModificationException
     * @param list
     * @return
     */
    public Collection<String> m2(Vector<String> list){
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String temp = it.next();
            if ("3".equals(temp)){
                list.remove(temp);
            }
        }
        return list;
    }

    public Collection<String> m3(Vector<String> list){
        for (int i = 0; i < list.size(); i++) {
            if ("3".equals(list.get(i))){
                list.remove(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        Vector<String> list = new Vector<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("4");

        UseSyncCollection obj = new UseSyncCollection();
        System.out.println(list.toString());
        Collection<String> strings = obj.m3(list);
        System.out.println(strings.toString());
    }
}
