package com.demo.mysql.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.demo.mysql.mapper"})
public class MybatisPlusConfig {
}
