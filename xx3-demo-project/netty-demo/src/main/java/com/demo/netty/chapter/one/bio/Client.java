package com.demo.netty.chapter.one.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/23 23:24
 * @Version V1.0
 **/
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 10001);
        socket = new Socket();
        // 进行三次握手连接到服务端
        try{
            socket.connect(address);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            out.writeUTF("WEI QIANG");
            out.flush();
            System.err.println("client one receive msg：" + in.readUTF());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
            in.close();
            out.close();
        }
    }
}
