package com.example.sprintbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.sprintbot", "Ctrl_c_Ctrl_v.demo"})
public class SprintbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbotApplication.class, args);
	}

}
