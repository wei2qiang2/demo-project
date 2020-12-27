package com.demo.rpc.registry.service;

import com.demo.rpc.common.entity.RegistryInfoVO;
import com.demo.rpc.common.enums.RegistryCenterRequestTypeEnum;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 20:58
 * @Version V1.0
 **/
@Service
public class RegistryCenterStarter {

    @Autowired
    private RegistryCenterService registryCenterService;

    private static class StartRegistryCenter implements Runnable {
        private Socket socket;
        private RegistryCenterService registryCenterService;

        public StartRegistryCenter(Socket s, RegistryCenterService registryCenterService) {
            this.socket = s;
            this.registryCenterService = registryCenterService;
        }

        @Override
        public void run() {
            try (
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ) {

                // 判断是注册服务还是调用服务
                RegistryCenterRequestTypeEnum requestTypeEnum = (RegistryCenterRequestTypeEnum) inputStream.readObject();
                switch (requestTypeEnum) {
                    case GET_SERVICE_LIST:
                        String serviceName = inputStream.readUTF();
                        Set<RegistryInfoVO> serviceList = registryCenterService.getService(serviceName);
//                        System.err.println("service list: " + serviceList.toString());
                        outputStream.writeObject(serviceList);
                        break;
                    case REGISTER_SERVICE:
                        String registServiceName = inputStream.readUTF();
                        String host = inputStream.readUTF();
                        int port = inputStream.readInt();
                        registryCenterService.registService(registServiceName, port, host);
                        outputStream.writeBoolean(true);
                        System.err.println("service regist success: " +
                                host + ":" + port + "=>" + registServiceName);
                        break;
                }
                outputStream.flush();
            } catch (Exception e) {
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

    @PostConstruct
    public void init() throws IOException {
        System.err.println("registry center started at: 127.0.0.1:8848");
        ServerSocket serverSocket = new ServerSocket();
        InetSocketAddress socketAddress = new InetSocketAddress(8848);
        serverSocket.bind(socketAddress);

        while (true) {
            new Thread(new StartRegistryCenter(serverSocket.accept(), this.registryCenterService)).start();
        }
    }
}
