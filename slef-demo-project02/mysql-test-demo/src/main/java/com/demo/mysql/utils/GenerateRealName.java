package com.demo.mysql.utils;

import com.demo.mysql.consts.Const;
import com.demo.mysql.factory.BeanFactory;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class GenerateRealName {


    public static String generateName() {
        String[] namesArr = Const.FAMILY_NAMES.split(" ");
        Set<String> set = new HashSet(Arrays.asList(namesArr));
        List<Object> firstNameList = Arrays.asList(set.toArray());
        Random random = null;
        random = (Random) BeanFactory.getInstance(Random.class);
        int firstNameIndex = random.nextInt(firstNameList.size());
        return String.valueOf(firstNameList.get(firstNameIndex)).toUpperCase() + getRandomChar();
    }

    private static String getRandomChar() {
        String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();
        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.err.println("错误");
        }
        return str;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        generateName();
    }
}
