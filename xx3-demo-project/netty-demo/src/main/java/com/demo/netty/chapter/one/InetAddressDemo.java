package com.demo.netty.chapter.one;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/23 22:16
 * @Version V1.0
 **/
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");

        System.err.println(inetAddress);

        InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");

        for (int i = 0; i < inetAddresses.length; i++) {
            System.err.println(inetAddresses[i].toString());
        }
        NetworkInterface networkInterfaces = NetworkInterface.getByInetAddress(InetAddress.getByName("127.0.0.1"));
        System.err.println(networkInterfaces);

        Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (interfaceEnumeration.hasMoreElements()) {
            System.err.println(interfaceEnumeration.nextElement());
        }

    }
}
