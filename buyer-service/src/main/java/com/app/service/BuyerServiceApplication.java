package com.app.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.app.service.controller.BuyerController;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = BuyerController.class,basePackages="com.app.service")

public class BuyerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerServiceApplication.class, args);
	}
}
