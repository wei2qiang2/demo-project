package com;

import java.util.Date;

public class TestEqualsAnd {


//    private int a;
//    private String b;
//    private Date date;

    public TestEqualsAnd() {
    }

//    public TestEqualsAnd(int a, String b, Date date) {
//        this.a = a;
//        this.b = b;
//        this.date = date;
//    }
//
//    public TestEqualsAnd(int a, String b) {
//        this.a = a;
//        this.b = b;
//    }
//
//    public TestEqualsAnd(int a) {
//        this.a = a;
//    }

    public static void main(String[] args) {
//        TestEqualsAnd t1 = new TestEqualsAnd(1,"a");
//        TestEqualsAnd t2 = new TestEqualsAnd(1, "a");
//
//        System.out.println(t1.equals(t2));//false
//        System.out.println(t1 == t2);//false

        TestEqualsAnd t1 = new TestEqualsAnd();
        TestEqualsAnd t2 = new TestEqualsAnd();

        System.out.println(t1.equals(t2));//false
        System.out.println(t1 == t2);//false


    }

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }
}
