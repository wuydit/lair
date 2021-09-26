package com.bigbear.comsumer;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wuyd
 * 2021/9/22 9:32
 */
@Log4j2
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ok/{id}")
    public String getById(@PathVariable("id") Long id){
        return paymentService.ok(id);
    }

    @HystrixCommand(fallbackMethod = "error",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
            })
    @GetMapping("/timeOut/{id}")
    public String timeOut(@PathVariable("id") Long id){
        return paymentService.timeout(id);
    }

    @GetMapping("/lb")
    public String lb(){
        return serverPort;
    }

    public String error(@PathVariable("id") Long id){
        return "超时";
    }
}
