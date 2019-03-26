package com.microservice.msstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableEurekaClient
@SpringBootApplication
public class MsStudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsStudentsApplication.class, args);
	}

}
