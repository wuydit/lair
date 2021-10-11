package com.bigbear.lair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wuyd
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LairSentinel9021Application {

    public static void main(String[] args) {
        SpringApplication.run(LairSentinel9021Application.class, args);
    }

}
