package com.example.sufa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SufaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SufaApplication.class, args);
	}

}
