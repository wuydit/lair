package com.bigbear.lair;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.bigbear.commons.entity.CommonResult;
import com.bigbear.commons.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyd
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResources")
    @SentinelResource(value = "byResources", blockHandler = "handleException")
    public CommonResult byResources(){
        return new CommonResult(200, "按照资源名称进行限流", new Payment("1"));
    }

    public CommonResult handleException(BlockException blockException){
        return new CommonResult(400, blockException.getClass().getCanonicalName(), new Payment("2"));
    }
}
