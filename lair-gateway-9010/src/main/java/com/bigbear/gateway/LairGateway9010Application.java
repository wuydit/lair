package com.bigbear.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableEurekaClient
@SpringBootApplication
public class LairGateway9010Application {

	public static void main(String[] args) {
		SpringApplication.run(LairGateway9010Application.class, args);
	}

}
