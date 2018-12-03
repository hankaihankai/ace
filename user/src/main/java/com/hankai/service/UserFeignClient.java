package com.hankai.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hankai.service.UserFeignClient.PrintErr;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@FeignClient(name = "config-client",fallback = PrintErr.class)
public interface UserFeignClient {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String pring(@RequestParam("id") String id);

    @Component
    static class PrintErr implements UserFeignClient {

        @Override
        public String pring(String id) {
            return "printErr" + id;
        }
    }
}
