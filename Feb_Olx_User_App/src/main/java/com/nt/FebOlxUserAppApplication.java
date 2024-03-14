package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FebOlxUserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FebOlxUserAppApplication.class, args);
	}

}
