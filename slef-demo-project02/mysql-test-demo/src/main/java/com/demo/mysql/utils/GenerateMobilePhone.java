package com.demo.mysql.utils;

import com.demo.mysql.consts.Const;
import com.demo.mysql.factory.BeanFactory;

import java.util.Random;

public class GenerateMobilePhone {

    private static Random random;

    static {
        random = (Random) BeanFactory.getInstance(Random.class);
    }

    public GenerateMobilePhone() throws InstantiationException, IllegalAccessException {
    }

    public static String generatePhone() {
        StringBuilder sb = new StringBuilder(Const.PHONE_PREFIX_ARRAY[random.nextInt(Const.PHONE_PREFIX_ARRAY.length)]);
        sb.append(getSuffix(8));
        return sb.toString();
    }

    public static String getSuffix(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(Const.CONST_NUMBER_ARR[random.nextInt(Const.CONST_NUMBER_ARR.length)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000000; i++) {
            System.out.println(generatePhone());
        }
    }
}
