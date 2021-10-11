package com.bigbear.lair;

import com.bigbear.commons.entity.CommonResult;
import com.bigbear.commons.entity.Payment;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
