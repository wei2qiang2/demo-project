package com.demo.mysql.utils;

import com.demo.mysql.consts.Const;
import com.demo.mysql.factory.BeanFactory;

import java.util.Random;

public class GenerateEmail {

    public static String generateEmail() {
        StringBuilder sb = new StringBuilder();
        Random random = null;
        random = (Random) BeanFactory.getInstance(Random.class);
        for (int j = 0; j < random.nextInt(20) + 1; j++) {
            int i = random.nextInt(Const.CHARR_ARR.length);
            sb.append(Const.CHARR_ARR[i]);
        }
        //从后缀列表随机取一个后缀
        sb.append(Const.CONST_EMAIL_SUFFIX_ARRAY[random.nextInt(Const.CONST_EMAIL_SUFFIX_ARRAY.length)]);
        return sb.toString();
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(generateEmail().toString());
        }
    }
}
