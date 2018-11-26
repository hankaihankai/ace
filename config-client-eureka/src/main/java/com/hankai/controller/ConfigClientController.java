package com.hankai.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.*;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${hankai.gender}")
    private String profile;

    @GetMapping("/hello")
    public String hello(){
        return this.profile;
    }

}
