package com.hankai.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.event.MouseInputListener;

@RestController
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/ribbon/{id}")
    @HystrixCommand(fallbackMethod = "printErr")
    public String print(@PathVariable String id) {
        return restTemplate.getForObject("http://web/login/" + id, String.class);
    }

    public String printErr(String id) {
        return "printErr:" + id;
    }
}
