package com.bigbear.lair.order.controller;

import com.bigbear.commons.entity.CommonResult;
import com.bigbear.commons.entity.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuyd
 * 2021/9/22 9:32
 */
@Log4j2
@RestController
public class ConsumerController {

    public static final String PAYMENT_URL = "http://PAYMENT-SERVICE";

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consumer/insert/{serial}")
    public CommonResult<Payment> create(@PathVariable("serial") String serial){
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/insert/" + serial, CommonResult.class);
        return commonResult;
    }

    @GetMapping("/consumer/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        CommonResult commonResult = restTemplate.getForObject(PAYMENT_URL + "/payment/getById/" + id, CommonResult.class);
        return commonResult;
    }
}
