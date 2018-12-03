package com.hankai;

import com.hankai.controller.RibbitMqServer;
import com.hankai.entity.RibbitMqMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 负载均衡
 */
@SpringBootApplication
@RestController
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);

    }

    @Autowired
    private RibbitMqServer ribbitMqServer;
    @GetMapping
    public void test() {
        ribbitMqServer.send("user-exchange", "user.*", new RibbitMqMessage());
    }




}
