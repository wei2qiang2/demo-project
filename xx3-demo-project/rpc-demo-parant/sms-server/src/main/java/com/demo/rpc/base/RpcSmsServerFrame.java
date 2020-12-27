package com.demo.rpc.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 21:23
 * @Version V1.0
 **/
@Service
public class RpcSmsServerFrame {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegistServiceToRegistryCenter registServiceToRegistryCenter;

    public void startService(String serviceName, String host, int port, Class impl) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(port));
        System.err.println("RPC Server: " + impl.getSimpleName() + "  start at port: " + port + "...");
        registerService.registerServer(serviceName, impl);
        registServiceToRegistryCenter.registService(serviceName,  port, host);
        try {
            while (true) {
                new Thread(new ServerTask(serverSocket.accept(), registerService)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static class ServerTask implements Runnable {
        private Socket socket;
        private RegisterService registerService;

        public ServerTask(Socket socket, RegisterService registerService) {
            this.socket = socket;
            this.registerService = registerService;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                // 服务名称
                String serviceName = inputStream.readUTF();
                // 方法名称
                String methodName = inputStream.readUTF();
                // 入参类型
                Class<?>[] paramTypes = (Class<?>[]) inputStream.readObject();
                // 参数值
                Object[] paramValue = (Object[]) inputStream.readObject();
                // 根据服务名获取实际的class对象
                Class serviceClass = registerService.getService(serviceName);
                if (Objects.isNull(serviceClass)) {
                    throw new RuntimeException(serviceName + " is not exist");
                }
                // 通过反射执行Class对象的方法
                Method method = serviceClass.getMethod(methodName, paramTypes);
                Object returnResult = method.invoke(serviceClass.newInstance(), paramValue);
                // 将方法的执行结果输出给对方
                outputStream.writeObject(returnResult);
                outputStream.flush();
            } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
