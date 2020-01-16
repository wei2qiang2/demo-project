package com.atguigu.interview.one.chapter2;

import java.util.Arrays;

public class ParamaterPass {

    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();

        change(i, str, num, arr, my);

        System.out.println("i = " + i); // 1
        System.out.println("str = " + str); // hello
        System.out.println("num = " + num); // 200
        System.out.println("arr = " + Arrays.toString(arr)); // 2,2,3,4,5
        System.out.println("my.a = " + my.a); // 11
    }

    public static void change(int j, String s, Integer n, int[] a, MyData m) {
        j += 1; // i的值是变了，但是给了j这个变量
        s += "world"; // String和包装类的不可变性
        n += 1; // String和包装类的不可变性  200超过了128，不再常量池中的常量了
        a[0] += 1; // 传的是地址值，改变了地址对应数组的第一个元素的值
        m.a += 1;// 传的是地址值，且是非包装类和String，所以会变
    }

}

class MyData {
    int a = 10;
}
