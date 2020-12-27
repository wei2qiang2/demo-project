package com.demo.rpc.remote;

import com.demo.rpc.remote.vo.UserInfo;

public interface ISmsService {

    UserInfo sendSms(UserInfo userInfo);
}
