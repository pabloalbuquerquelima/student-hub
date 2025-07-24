package com.pabloalbuquerque.student_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pabloalbuquerque.student_hub")
public class StudentHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentHubApplication.class, args);
	}

}
