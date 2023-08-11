package com.josam.clink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@EnableScheduling
@SpringBootApplication
public class ClinkApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClinkApplication.class, args);
	}

}
