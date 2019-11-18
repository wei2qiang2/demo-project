package com.demo.mysql.utils;

import com.demo.mysql.enums.TimeEnum;
import com.demo.mysql.factory.BeanFactory;

import java.util.Date;
import java.util.Random;

import static com.demo.mysql.enums.TimeEnum.DAY;

public class GenerateDate {

    /**
     * 生成据当前时间多长时间的范围
     *
     * @param num      时间长度
     * @param timeEnum 时间类型
     * @return
     */
    public static Date generateDate(int num, TimeEnum timeEnum) {
        Date retunData = null;
        long currentTime = new Date().getTime();
        long difTime = 0L;
        switch (timeEnum) {
            case SECOND:
                difTime = 1000 * num;
                break;
            case MINUTES:
                difTime = 1000 * 60 * num;
            case HOUR:
                difTime = 60 * 60 * 1000 * num;
                break;
            case DAY:
                difTime = 24 * 60 * 60 * 1000 * num;
                break;
            case WEEK:
                difTime = 7 * 24 * 60 * 60 * 1000 * num;
                break;
            default:
                break;

        }
        Random r = null;
        r = (Random) BeanFactory.getInstance(Random.class);
        long time = nextLong(r, difTime);
        retunData = new Date(currentTime - time);
        return retunData;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < 10000; i++) {
            System.out.println(generateDate(5, DAY));
        }
    }

    public static long nextLong(Random rng, long n) {
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0L);
        return val;
    }
}
