package com.demo.rpc.config;

import com.demo.rpc.remote.ISmsService;
import com.demo.rpc.rpc.RpcClientFrame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 18:39
 * @Version V1.0
 **/
@Configuration
public class BeanFactoryConfig {

    @Bean
    public ISmsService getSmsService() throws Exception {
        return RpcClientFrame.getService(ISmsService.class);
    }
}
