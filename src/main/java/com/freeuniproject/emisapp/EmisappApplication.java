package com.freeuniproject.emisapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
//@SpringBootApplication
public class EmisappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmisappApplication.class, args);
	}

}
