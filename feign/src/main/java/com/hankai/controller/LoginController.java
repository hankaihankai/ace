package com.hankai.controller;

import com.hankai.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

    @Autowired
    private UserFeignClient userFeignClient;
    @GetMapping("/feign/{id}")
    public String print(@PathVariable String id) {
        return userFeignClient.pring(id);
    }
}
