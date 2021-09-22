package com.bigbear.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class LairProviderPayment9006Application {

	public static void main(String[] args) {
		SpringApplication.run(LairProviderPayment9006Application.class, args);
	}

}
