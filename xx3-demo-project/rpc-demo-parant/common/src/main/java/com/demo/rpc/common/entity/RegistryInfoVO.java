package com.demo.rpc.common.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/27 20:39
 * @Version V1.0
 **/
@Data
@Builder
@ToString
public class RegistryInfoVO implements Serializable {

    private String host;
    private Integer port;

}
