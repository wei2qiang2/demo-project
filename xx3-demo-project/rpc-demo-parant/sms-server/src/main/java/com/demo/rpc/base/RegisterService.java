package com.demo.rpc.base;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 服务注册信息
 * @Author wq
 * @Date 2020/12/24 21:20
 * @Version V1.0
 **/
@Service
public class RegisterService {

    private static Map<String, Class> serviceCache = new ConcurrentHashMap<>();

    /**
     *  注册服务
     * @param serviceName
     * @param cls
     */
    public void registerServer(String serviceName, Class cls) {
        serviceCache.put(serviceName, cls);
    }

    /**
     * 根据服务名称查询到服务
     * @param serviceName
     * @return
     */
    public Class getService(String serviceName) {
        return serviceCache.get(serviceName);
    }
}
