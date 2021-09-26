package com.bigbear.consumer.service;

import com.bigbear.commons.entity.CommonResult;
import com.bigbear.commons.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wuyd
 * 2021/9/23 15:57
 */
@Service
@FeignClient(value = "PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/getById/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);
}
