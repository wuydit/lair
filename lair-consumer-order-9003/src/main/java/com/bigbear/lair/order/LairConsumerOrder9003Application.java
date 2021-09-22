package com.bigbear.lair.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableEurekaClient
@SpringBootApplication
public class LairConsumerOrder9003Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConsumerOrder9003Application.class, args);
	}

}
