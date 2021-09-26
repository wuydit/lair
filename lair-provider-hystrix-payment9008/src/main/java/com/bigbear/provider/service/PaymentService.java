package com.bigbear.provider.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wuyd
 * 2021/9/26 10:56
 */
@Service
public class PaymentService {

    /**
     * ok
     * @param id id
     * @return s
     */
    public String paymentInfo(Integer id){
        return "Thread poll:" + Thread.currentThread().getName() + "id:" + id + "OK";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfoTimeOut(Integer id){
        try{
            TimeUnit.SECONDS.sleep(id);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "Thread poll:" + Thread.currentThread().getName() + "id:" + id + ".耗时" + id + "s.";
    }

    public String paymentInfoTimeHandler(Integer id){
        return "Thread poll:" + Thread.currentThread().getName() + "paymentInfoTimeHandler. id:" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("订单不存在");
        }
        return Thread.currentThread().getName() + "订单:" + id + "成功支付下单";
    }

    public String paymentCircuitBreakerFallback(Integer id){
        return "负载过高,暂停服务";
    }


}
