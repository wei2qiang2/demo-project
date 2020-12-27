package com.demo.rpc.common.utils;

import com.demo.rpc.common.entity.RegistryInfoVO;
import com.demo.rpc.common.enums.RegistryCenterRequestTypeEnum;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 22:11
 * @Version V1.0
 **/
public class RegistryUtils {

    /*获得服务提供者的地址*/
    public static List<InetSocketAddress> getServiceList(String serviceName)
            throws Exception {
        Socket socket = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress("127.0.0.1", 8848));
            output = new ObjectOutputStream(socket.getOutputStream());
            //需要获得服务提供者
            output.writeObject(RegistryCenterRequestTypeEnum.GET_SERVICE_LIST);
            //告诉注册中心服务名
            output.writeUTF(serviceName);
            output.flush();

            input = new ObjectInputStream(socket.getInputStream());
            Set<RegistryInfoVO> result
                    = (Set<RegistryInfoVO>) input.readObject();
            List<InetSocketAddress> services = new ArrayList<>();
            for (RegistryInfoVO serviceVo : result) {
                String host = serviceVo.getHost();
                int port = serviceVo.getPort();
                InetSocketAddress serviceAddr = new InetSocketAddress(host, port);
                services.add(serviceAddr);
            }
            System.out.println("获得服务[" + serviceName
                    + "]提供者的地址列表[" + services + "]，准备调用.");
            return services;
        } finally {
            socket.close();
            output.close();
            input.close();
        }
    }

    /*获得远程服务的地址*/
    public static InetSocketAddress getService(String serviceName)
            throws Exception {
        //获得服务提供者的地址列表
        Random r = new Random();
        List<InetSocketAddress> serviceVoList = getServiceList(serviceName);
        InetSocketAddress addr
                = serviceVoList.get(r.nextInt(serviceVoList.size()));
        System.out.println("本次选择了服务器："+addr);
        return addr;
    }
}
