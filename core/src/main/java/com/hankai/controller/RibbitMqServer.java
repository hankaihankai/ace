package com.hankai.controller;

import com.alibaba.fastjson.JSON;
import com.hankai.entity.RibbitMqMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.stereotype.Component;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.Map;


/**
 * 服务端
 * 消息管理(1.短信 2.站内信)
 * @auther ywl
 */
@Component
@Slf4j
public class RibbitMqServer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 服务端
     * @param msg
     */
    public void send(String exchange, String routingKey, RibbitMqMessage msg) {
        try {
            log.info("-----消息发送开始------");
            amqpTemplate.convertAndSend(exchange,
                    routingKey,JSON.toJSONString(msg));
            log.info("-----消息发送结束------");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
