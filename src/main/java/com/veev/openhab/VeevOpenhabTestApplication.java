package com.veev.openhab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VeevOpenhabTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeevOpenhabTestApplication.class, args);
	}

}
