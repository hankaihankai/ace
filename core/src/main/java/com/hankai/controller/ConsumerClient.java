package com.hankai.controller;

import com.alibaba.fastjson.JSONObject;
import com.hankai.commen.RibbitMqConstant;
import com.hankai.entity.RibbitMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.hankai.commen.RibbitMqConstant.QUEUE_MSG_SEND;

/**
 * 消费端
 */
@Component
//@RabbitListener(queues = QUEUE_MSG_SEND)
@Slf4j
public class ConsumerClient {
    /*@RabbitListener(bindings ={@QueueBinding(value = @Queue(value = QUEUE_MSG_SEND),
            exchange =@Exchange(value = "user-exchange"),key = "user.*")})*/
    @RabbitListener(queues = "user-queue")
    public void add(String msg) {
        RibbitMqMessage ribbitMqMessage = JSONObject.parseObject(msg, RibbitMqMessage.class);
        System.out.println("================获取开始");
        System.out.println(msg);
    }
}
