package com.bigbear.lair;

import com.bigbear.commons.entity.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuyd
 * 2021/9/22 9:32
 */
@Log4j2
@RestController
public class ConsumerController {

    private final RestTemplate restTemplate;

    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public CommonResult echo(@PathVariable String id) {
        return restTemplate.getForObject("http://nacos-payment-service/payment/getById/" + id, CommonResult.class);
    }
}
