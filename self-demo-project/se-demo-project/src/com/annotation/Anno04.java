package com.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@Retention(RetentionPolicy.RUNTIME)

@Documented
public @interface Anno04 {
    String className();
    String methodName();
}
