package com.demo.rpc.base;

import com.demo.rpc.common.entity.RegistryInfoVO;
import com.demo.rpc.common.enums.RegistryCenterRequestTypeEnum;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Set;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 21:31
 * @Version V1.0
 **/
@Service
public class RegistServiceToRegistryCenter {

    public void registService(String serviceName, int port, String host) {
        new Thread(new RegistServiceTask(RegistryCenterRequestTypeEnum.REGISTER_SERVICE, serviceName, host, port)).start();
    }

    public Set<RegistryInfoVO> getServiceList(String serviceName) {
        new Thread(new RegistServiceTask(RegistryCenterRequestTypeEnum.GET_SERVICE_LIST, serviceName)).start();
        return null;
    }

    private static class RegistServiceTask implements Runnable {

        private Socket socket;
        ObjectOutputStream out;
        ObjectInputStream in;
        private String serviceName;
        private String host;
        private int port;
        private RegistryCenterRequestTypeEnum type;

        public RegistServiceTask(RegistryCenterRequestTypeEnum registType, String serviceName, String host, int port) {
            this.serviceName = serviceName;
            this.host = host;
            this.port = port;
            this.type = registType;
        }

        public RegistServiceTask(RegistryCenterRequestTypeEnum getServiceList, String serviceName) {
            this.type = getServiceList;
            this.serviceName = serviceName;
        }

        @SneakyThrows
        @Override
        public void run() {
            try {
                InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8848);
                socket = new Socket();
                socket.connect(address);
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                // 注册服务标志
                out.writeObject(this.type);
                // 写服务名称
                out.writeUTF(serviceName);
                // 写服务host
                out.writeUTF(host);
                // 写服务端口
                out.writeInt(port);
                out.flush();
                boolean b = in.readBoolean();
                System.err.println(host + ":" + port + "=>" + serviceName + " 注册结果： " + b);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                socket.close();
                in.close();
                out.close();
            }

        }
    }
}
