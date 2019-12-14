package com.demo.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
public class MysqlTestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlTestDemoApplication.class, args);
    }

}
