package com.app.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import com.app.service.controller.ItemController;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = ItemController.class,basePackages="com.app.service")

public class SellerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerServiceApplication.class, args);
	}
}
