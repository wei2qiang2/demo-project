package com.demo.mysql.utils;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class ChangeToPinYinJP {
    public static String changeToTonePinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr =  PinyinHelper.convertToPinyinString(pinYinStr,"", PinyinFormat.WITHOUT_TONE);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;

    }
    /**
     * 转换为每个汉字对应拼音首字母字符串
     * @param pinYinStr 需转换的汉字
     * @return 拼音字符串
     */
    public static String changeToGetShortPinYin(String pinYinStr){

        String tempStr = null;

        try
        {
            tempStr = PinyinHelper.getShortPinyin(pinYinStr);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return tempStr;

    }
}