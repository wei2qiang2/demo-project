package com.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
//
//        Object b = 2;
//        b = 3;
//
//        System.out.println(b);

//        Integer a = 1000;
//        System.out.println(a ^ a >>> 16);
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString(a >>> 16));
//        System.out.println(Integer.toBinaryString(a));
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            hm.put(i, i);
        }
//        Set<Integer> i = hm.keySet();
//        for (Integer i1 : i) {
//            System.out.println(hm.get(i1));
//        }


        for (Map.Entry<Integer, Integer> entry: hm.entrySet()){
            System.out.println(entry.getKey()+"=" + entry.getValue());
        }
        //System.out.println(hm);
    }
}
