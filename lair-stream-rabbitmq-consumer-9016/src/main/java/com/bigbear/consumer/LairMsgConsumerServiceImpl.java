package com.bigbear.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author wuyd
 * 2021/10/9 14:14
 */
@Slf4j
@Service
@EnableBinding(Sink.class)
public class LairMsgConsumerServiceImpl {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> msg) {
        log.info("收到: {}.", msg.getPayload());
    }
}
