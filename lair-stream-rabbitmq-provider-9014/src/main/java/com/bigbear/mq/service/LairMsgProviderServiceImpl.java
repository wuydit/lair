package com.bigbear.mq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author wuyd
 * 2021/10/9 14:14
 */
@Slf4j
@Service
@EnableBinding(Source.class)
public class LairMsgProviderServiceImpl implements LairMsgProviderService {

    @Resource
    @Qualifier("nullChannel")
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        log.info("send: {}.", serial);
        return null;
    }
}
