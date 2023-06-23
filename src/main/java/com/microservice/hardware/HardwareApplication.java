package com.microservice.hardware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(info =
@Info(title = "hardware API", version = "1.0", description = "Documentation Employee API v1.0")
)
public class HardwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HardwareApplication.class, args);
	}

}
