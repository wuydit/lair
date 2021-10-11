package com.bigbear.lair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LairConsumerNacos9018Application {

	public static void main(String[] args) {
		SpringApplication.run(LairConsumerNacos9018Application.class, args);
	}

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
