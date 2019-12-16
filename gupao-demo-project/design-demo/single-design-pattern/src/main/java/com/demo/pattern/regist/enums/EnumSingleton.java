package com.demo.pattern.regist.enums;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 注册式： 解决序列化破坏单例的问题
 * 注册式单例模式之枚举类型
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) throws IOException {
        this.data = data;
    }
}
