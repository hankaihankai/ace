package com.hankai.utils;

import com.hankai.controller.RibbitMqServer;
import com.hankai.entity.RibbitMqMessage;
import org.springframework.amqp.rabbit.core.RabbitManagementTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class RabbitMqUtils {

    @Autowired
    private RibbitMqServer ribbitMqServer;
    private static RabbitMqUtils rabbitMqUtils;
    @PostConstruct
    private void init() {
        rabbitMqUtils = this;
        rabbitMqUtils.ribbitMqServer = this.ribbitMqServer;
    }

    /**
     * 发送  mq 消息
     * @param exchange 转发器
     * @param routingKey
     * @param msg  信息
     */
    public static void send(String exchange, String routingKey, RibbitMqMessage msg) {
        rabbitMqUtils.ribbitMqServer.send(exchange, routingKey, msg);
    }

}
