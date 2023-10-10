package com.constraintvalidation;

import in.ADemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConstraintvalidationSpringboot3Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ConstraintvalidationSpringboot3Application.class, args);
		RestTemplate aDemo = context.getBean(RestTemplate.class);
		//aDemo.testADemo();
	}

}
