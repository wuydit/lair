package com.bigbear.consumer.controller;

import com.bigbear.commons.entity.CommonResult;
import com.bigbear.commons.entity.Payment;
import com.bigbear.consumer.service.PaymentService;
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

    private final PaymentService paymentService;

    public ConsumerController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/consumer/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        return paymentService.getById(id);
    }
}
