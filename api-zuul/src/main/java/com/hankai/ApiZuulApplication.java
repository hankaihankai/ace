package com.hankai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 配置中心 服务端
 */
@SpringBootApplication
@EnableZuulProxy
public class ApiZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class, args);
    }


}
