package com.demo.rpc.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 20:11
 * @Version V1.0
 **/
@Data
@Builder
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2075989883122286707L;

    private String userName;

    private String email;
}
