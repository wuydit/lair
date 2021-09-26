package com.bigbear.provider.controller;

import com.bigbear.provider.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuyd
 * 2021/9/26 11:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo(id);
        log.info("paymentInfo:{} 端口触发, result:{}", serverPort, result);
        return result;
    }

    @GetMapping("hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);
        log.info("paymentInfoTimeOut:{} 端口触发, result:{}", serverPort, result);
        return result;
    }

    @GetMapping("hystrix/cb/{id}")
    public String cb(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("paymentCircuitBreaker:{} 端口触发, result:{}", serverPort, result);
        return result;
    }

}
