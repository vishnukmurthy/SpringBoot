package com.carbonfive.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		System.out.println("Demo Starting");
		SpringApplication.run(DemoApplication.class, args);
	}

}
