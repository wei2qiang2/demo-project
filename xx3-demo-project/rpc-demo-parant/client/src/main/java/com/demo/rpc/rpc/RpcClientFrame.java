package com.demo.rpc.rpc;


import com.demo.rpc.common.utils.RegistryUtils;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 18:28
 * @Version V1.0
 **/
public class RpcClientFrame {


    public static <T> T getService(Class<?> serviceClass) throws Exception {
//        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8878);
        InetSocketAddress inetAddress = RegistryUtils.getService(serviceClass.getName());
        T t =  (T) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class[]{serviceClass}, new DynamicInvocationHandler(serviceClass, inetAddress));
        return t;
    }

    private static class DynamicInvocationHandler implements InvocationHandler {

        private Class<?> serviceClass;
        private InetSocketAddress inetAddress;

        public DynamicInvocationHandler(Class<?> serviceClass, InetSocketAddress inetAddress) {
            this.serviceClass = serviceClass;
            this.inetAddress = inetAddress;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            Socket socket = new Socket();
            ObjectOutputStream objectOutputStream = null;
            ObjectInputStream inputStream = null;
            socket.connect(inetAddress);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            // 写服务名称
            objectOutputStream.writeUTF(serviceClass.getName());
            // 写方法名称
            objectOutputStream.writeUTF(method.getName());
            // 写方法参数类型
            objectOutputStream.writeObject(method.getParameterTypes());
            // 写方法参数
            objectOutputStream.writeObject(args);
            objectOutputStream.flush();
            // 读取返回值
            inputStream = new ObjectInputStream(socket.getInputStream());
            Object result = inputStream.readObject();
            System.err.println("client invoke success: " + result);

            socket.close();
            objectOutputStream.close();
            inputStream.close();
            return result;

        }
    }

}
