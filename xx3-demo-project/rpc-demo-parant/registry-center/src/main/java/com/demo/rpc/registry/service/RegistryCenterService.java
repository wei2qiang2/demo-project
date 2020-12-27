package com.demo.rpc.registry.service;

import com.demo.rpc.common.entity.RegistryInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 20:49
 * @Version V1.0
 **/
@Service
public class RegistryCenterService {


    private static Map<String, Set<RegistryInfoVO>> serviceHolder = new HashMap<>();


    public synchronized boolean registService(String serviceName, int servicePort, String host){
        Set<RegistryInfoVO> infoVOSet = serviceHolder.get(serviceName);
        if (CollectionUtils.isEmpty(infoVOSet)) {
            infoVOSet = new HashSet<>();
        }
        RegistryInfoVO registryInfoVO = RegistryInfoVO.builder()
                .host(host)
                .port(servicePort)
                .build();

        infoVOSet.add(registryInfoVO);
        serviceHolder.put(serviceName, infoVOSet);
        return true;
    }

    public Set<RegistryInfoVO> getService(String serviceName) {
        return serviceHolder.get(serviceName);
    }

}
