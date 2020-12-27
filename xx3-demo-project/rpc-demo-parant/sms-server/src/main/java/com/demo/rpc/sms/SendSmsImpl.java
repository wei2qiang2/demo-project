package com.demo.rpc.sms;

import com.demo.rpc.remote.ISmsService;
import com.demo.rpc.remote.vo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 22:33
 * @Version V1.0
 **/
@Service
public class SendSmsImpl implements ISmsService {
    @Override
    public UserInfo sendSms(UserInfo userInfo) {
        System.err.println("send sms to: " + userInfo.getEmail());
        return userInfo;
    }
}
