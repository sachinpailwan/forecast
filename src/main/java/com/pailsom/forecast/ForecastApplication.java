package com.pailsom.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan( basePackages = {"com.pailsom.forecast.entity"} )
public class ForecastApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForecastApplication.class, args);
	}

}
