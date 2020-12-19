package com.flash;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.flash.mapper")
public class FlashDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashDataApplication.class, args);
    }

}
