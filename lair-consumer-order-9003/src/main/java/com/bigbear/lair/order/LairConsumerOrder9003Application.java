package com.bigbear.lair.order;

import com.bigbear.myrule.MySelfRule;
import com.bigbear.myrule.ThreeRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wuyd
 */
//@RibbonClient(name = "PAYMENT-SERVICE", configuration = ThreeRule.class)
@EnableEurekaClient
@SpringBootApplication
public class LairConsumerOrder9003Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConsumerOrder9003Application.class, args);
	}

}
