package com.bigbear.comsumer;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyd
 * 2021/9/22 9:32
 */
@Log4j2
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    private final PaymentService paymentService;

    public ConsumerController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

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

    public String error(@PathVariable("id") Long id){
        return "超时";
    }
}
