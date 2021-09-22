package com.bigbear.laireurekaserver9004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wuyd
 */
@EnableEurekaServer
@SpringBootApplication
public class LairEurekaServer9004Application {

	public static void main(String[] args) {
		SpringApplication.run(LairEurekaServer9004Application.class, args);
	}

}
