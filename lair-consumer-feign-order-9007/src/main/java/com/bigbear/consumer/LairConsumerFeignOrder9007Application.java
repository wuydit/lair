package com.bigbear.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wuyd
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class LairConsumerFeignOrder9007Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConsumerFeignOrder9007Application.class, args);
	}

}
