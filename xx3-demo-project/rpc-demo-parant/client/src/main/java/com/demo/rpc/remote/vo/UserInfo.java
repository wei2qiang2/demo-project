package com.demo.rpc.remote.vo;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/24 22:32
 * @Version V1.0
 **/
@Data
@Builder
public class UserInfo implements Serializable {
    private String userName;
    private String email;
}
