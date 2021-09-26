package com.bigbear.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class LairConfigServer9011Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConfigServer9011Application.class, args);
	}

}
