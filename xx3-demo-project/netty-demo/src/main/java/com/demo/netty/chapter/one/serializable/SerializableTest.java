package com.demo.netty.chapter.one.serializable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.time.LocalDate;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 20:16
 * @Version V1.0
 **/

public class SerializableTest {

    // 使用JDK自带的序列化
    private static void testJdkSerializable(int loop, UserInfo userInfo) throws IOException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(userInfo);
            os.flush();
            os.close();

            byte[] b = bos.toByteArray();
            bos.close();
        }
        long endMills = System.currentTimeMillis();
        System.out.println("jdk serializable cost: " + (endMills - currentTimeMillis) + " ms");
    }

    private static void testSelfSerializable(int loop, UserInfo userInfo) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        long start = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            byte[] b = userInfo.codeC(byteBuffer);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The byte array serializable cost time is : "
                + (endTime - start) + " ms");
    }

    public static void main(String[] args) throws IOException {
        UserInfo userInfo = UserInfo.builder()
                .name("serializable demo")
                .birthDay(LocalDate.now())
                .sex(1)
                .build();
        testJdkSerializable(1000000, userInfo);
        testSelfSerializable(1000000, userInfo);
    }
}
