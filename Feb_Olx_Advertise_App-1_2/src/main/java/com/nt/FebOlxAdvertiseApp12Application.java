package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FebOlxAdvertiseApp12Application {

	public static void main(String[] args) {
		SpringApplication.run(FebOlxAdvertiseApp12Application.class, args);
	}

}
