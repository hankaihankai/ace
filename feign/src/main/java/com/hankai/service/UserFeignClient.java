package com.hankai.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hankai.service.UserFeignClient.PrintErr;

@FeignClient(name = "web",fallback = PrintErr.class)
public interface UserFeignClient {
    @RequestMapping("/login/{id}")
    public String pring(@PathVariable("id") String id);

    @Component
    static class PrintErr implements UserFeignClient {

        @Override
        public String pring(String id) {
            return "printErr" + id;
        }
    }
}
