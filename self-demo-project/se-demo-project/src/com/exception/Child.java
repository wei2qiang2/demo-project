package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Child extends Parent {

    @Override
    public void test1() throws FileNotFoundException {
        super.test1();
    }

    @Override
    public void test2() throws FileNotFoundException {
       new FileInputStream("");
    }
}
