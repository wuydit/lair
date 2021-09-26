package com.bigbear.comsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuyd
 * 2021/9/23 15:57
 */
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("hystrix/timeout/{id}")
    String timeout(@PathVariable("id") Long id);

    @GetMapping("/hystrix/ok/{id}")
    String ok(@PathVariable("id") Long id);
}
