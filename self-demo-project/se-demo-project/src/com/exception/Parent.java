package com.exception;

import java.io.FileNotFoundException;

abstract class Parent {

    public void test1() throws FileNotFoundException {

    }

    abstract public void test2() throws FileNotFoundException;
}
