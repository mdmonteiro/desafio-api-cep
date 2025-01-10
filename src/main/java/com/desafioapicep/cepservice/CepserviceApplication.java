package com.desafioapicep.cepservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CepserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CepserviceApplication.class, args);
	}

}
