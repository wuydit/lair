package com.bigbear.payment.controller;

import com.bigbear.payment.dto.CommonResult;
import com.bigbear.payment.entity.Payment;
import com.bigbear.payment.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @author wuyd
 * 2021/9/22 9:32
 */
@Log4j2
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment/insert/{serial}")
    public CommonResult<Payment> create(@PathVariable("serial") String serial){
        Payment payment = new Payment(serial);
        long result = paymentService.insert(payment);
        log.info("生成ID:{}", result);
        payment.setId(result);
        if (result > 0) {
            return new CommonResult<>(0,"成功", payment);
        }
        return new CommonResult<>(-1,"成功");
    }

    @GetMapping("/payment/getById/{id}")
    public CommonResult<Payment> getById(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        log.info("获取");
        return new CommonResult<>(0,"成功", payment);
    }
}
