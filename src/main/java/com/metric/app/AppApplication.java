package com.metric.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class AppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
}
