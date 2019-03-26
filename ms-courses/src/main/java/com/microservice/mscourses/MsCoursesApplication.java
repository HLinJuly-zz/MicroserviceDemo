package com.microservice.mscourses;

import com.microservice.mscourses.config.RibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@RibbonClient(name="student-service", configuration=RibbonConfiguration.class)
public class MsCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCoursesApplication.class, args);
	}

}
