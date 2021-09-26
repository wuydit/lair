package com.bigbear.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;

/**
 * @author wuyd
 * 2021/9/23 14:25
 */
public class MySelfRule {

//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//    }

    @Bean
    public IRule myRule(){
        return new ThreeRule();
    }

}
