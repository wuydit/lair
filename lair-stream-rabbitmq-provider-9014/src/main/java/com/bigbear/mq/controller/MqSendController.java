package com.bigbear.mq.controller;

import com.bigbear.mq.service.LairMsgProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyd
 * 2021/10/9 14:25
 */
@RestController
public class MqSendController {

    private final LairMsgProviderService lairMsgProviderService;

    public MqSendController(LairMsgProviderService lairMsgProviderService) {
        this.lairMsgProviderService = lairMsgProviderService;
    }

    @GetMapping("/sendMsg")
    public String sendMsg(){
        return this.lairMsgProviderService.send();
    }
}
