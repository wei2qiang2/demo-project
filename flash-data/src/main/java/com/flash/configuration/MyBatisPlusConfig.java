package com.flash.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author wq
 * @Date 2020/12/19 12:22
 * @Version V1.0
 **/
public class MyBatisPlusConfig {
    @Configuration
    public class MybatisPlusConfig {

        /**
         * 分页插件
         */
        @Bean
        public PaginationInterceptor paginationInterceptor() {
            return new PaginationInterceptor();
        }
    }

}
