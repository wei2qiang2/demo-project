package com.demo.rpc.sms;

import com.demo.rpc.base.RpcSmsServerFrame;
import com.demo.rpc.remote.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 22:30
 * @Version V1.0
 **/
@Service
public class RpcSmsServer {

    @Autowired
    private RpcSmsServerFrame smsServerFrame;

    @PostConstruct
    public void server() throws IOException {
        smsServerFrame.startService(ISmsService.class.getName(), "127.0.0.1", 8875, SendSmsImpl.class);
    }
}
