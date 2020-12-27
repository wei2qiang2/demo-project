package com.demo.netty.chapter.one.serializable;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.LocalDate;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 20:13
 * @Version V1.0
 **/

@Data
@Builder
public class UserInfo implements Serializable {
    private String name;
    private LocalDate birthDay;
    private Integer sex;

    //自行序列化
    public byte[] codeC() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] value = this.name.getBytes();//userName转换为字节数组value
        buffer.putInt(value.length);//写入字节数组value的长度
        buffer.put(value);//写入字节数组value的值
        buffer.putInt(this.sex);//写入userID的值
        buffer.put(this.birthDay.toString().getBytes());
        buffer.flip();//准备读取buffer中的数据
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);//buffer中的数据写入字节数组并作为结果返回
        return result;
    }

    //自行序列化方法2
    public byte[] codeC(ByteBuffer buffer) {
        buffer.clear();
        byte[] value = this.name.getBytes();
        buffer.putInt(value.length);
        buffer.put(value);
        buffer.putInt(this.sex);
        buffer.put(this.birthDay.toString().getBytes());
        buffer.flip();
        value = null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}
