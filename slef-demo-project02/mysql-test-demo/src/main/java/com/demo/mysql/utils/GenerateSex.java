package com.demo.mysql.utils;

import com.demo.mysql.factory.BeanFactory;

import java.util.Random;

public class GenerateSex {

    public static int generateSex() {
        Random r = null;
        r = (Random) BeanFactory.getInstance(Random.class);
        return r.nextInt(2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(generateSex());
                }
            }).start();
        }
    }
}
