package com.demo.mysql.utils;

import com.demo.mysql.consts.Const;

public class GenerateAccountAndPassword {

    public static String generateAccount(String realName){
        //生成账号
        return ChangeToPinYinJP.changeToTonePinYin(realName);
    }

    public static String generatePasssword(String realName){
        //生成密码
        return MD5Util.getMicrosoftMD5(Const.DEFAULT_PASSWORD + "_" + generateSalt(realName));
    }

    public static String generateSalt(String realName){
        //生成盐值
        return ChangeToPinYinJP.changeToGetShortPinYin(realName);
    }

    public static void main(String[] args) {
        System.out.println(generateAccount("魏强"));
        System.out.println(generatePasssword("魏强"));
        System.out.println(generateSalt("魏强"));
    }
}
