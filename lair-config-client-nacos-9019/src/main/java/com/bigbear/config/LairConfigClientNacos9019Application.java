package com.bigbear.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LairConfigClientNacos9019Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConfigClientNacos9019Application.class, args);
	}

}
