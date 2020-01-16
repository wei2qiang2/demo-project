package com.atguigu.interview.one.chapter1;

public class AutoIncrement {

    public static void main(String[] args) {
        int i = 1; // i =1
        i = i++; // i = 2
        System.err.println(i);
        int j = i++; // i = 3; j = 2
        System.err.println(i);
        int k = i + ++i * i++; // k = 3 + 4 * 4 = 19
        System.err.println("i = " + i); // 5
        System.err.println("j = " + j); // 2
        System.err.println("k = " + k); // 19
    }
}
