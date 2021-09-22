package com.bigbear.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableEurekaClient
@SpringBootApplication
public class LairProviderPayment9002Application {

	public static void main(String[] args) {
		SpringApplication.run(LairProviderPayment9002Application.class, args);
	}

}
