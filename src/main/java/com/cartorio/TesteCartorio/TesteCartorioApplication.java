package com.cartorio.TesteCartorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TesteCartorioApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TesteCartorioApplication.class, args);
	}

}
