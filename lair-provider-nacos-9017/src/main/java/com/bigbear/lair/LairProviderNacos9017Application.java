package com.bigbear.lair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LairProviderNacos9017Application {

	public static void main(String[] args) {
		SpringApplication.run(LairProviderNacos9017Application.class, args);
	}

}
