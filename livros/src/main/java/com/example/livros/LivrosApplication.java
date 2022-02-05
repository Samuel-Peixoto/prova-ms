package com.example.livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrosApplication.class, args);
	}

}
