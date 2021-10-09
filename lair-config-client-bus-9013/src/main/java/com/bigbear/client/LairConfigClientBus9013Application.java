package com.bigbear.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableEurekaClient
@SpringBootApplication
public class LairConfigClientBus9013Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConfigClientBus9013Application.class, args);
	}

}
