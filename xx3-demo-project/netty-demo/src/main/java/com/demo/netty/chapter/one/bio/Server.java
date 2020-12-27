package com.demo.netty.chapter.one.bio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/23 23:09
 * @Version V1.0
 **/
public class Server {
    private  static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
            50, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(10001));
        System.err.println("server start......");
        while (true) {
            threadPoolExecutor.execute(new ServerTask(serverSocket.accept()));
        }
    }
    private static class ServerTask implements Runnable {
        private Socket socket = null;
        public ServerTask(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                String receiveMsg = in.readUTF();
                System.err.println("Server receive msg: " + receiveMsg);
                // 此时并没有发送，只是放在缓冲区
                out.writeUTF("Hello! " + receiveMsg);
                // 强制刷出，发送到客户端
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
