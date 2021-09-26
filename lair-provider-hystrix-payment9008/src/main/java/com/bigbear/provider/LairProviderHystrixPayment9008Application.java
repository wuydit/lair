package com.bigbear.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class LairProviderHystrixPayment9008Application {

	public static void main(String[] args) {
		SpringApplication.run(LairProviderHystrixPayment9008Application.class, args);
	}

}
